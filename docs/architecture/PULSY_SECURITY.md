# PULSY — SECURITY & PERMISSION ARCHITECTURE SPECIFICATION

> **Version:** 1.0.0  
> **Status:** RATIFIED  
> **Scope:** Authentication, Network Boundaries, Secrets Hygiene, and Access Control

---

## 1. Core Security Principles

### 1.1 Zero Secrets in Git
- **Strict Rule:** Never commit passwords, database credentials, API keys, or private tokens to the Git repository.
- Development credentials (e.g. n8n tokens, database endpoints) must be injected via environment variables (`.env` file mapped via Secrets Gradle plugin or container secrets).
- `.env` is ignored by Git; `.env.example` contains only placeholder keys.

### 1.2 Strict UI Isolation (No Direct Database Access)
- The presentation layer (Android Compose UI) must never hold database credentials or initiate direct TCP connections to PostgreSQL (port 5432) or Redis (port 6379).
- Clients communicate exclusively through authenticated REST, WebSocket, or gRPC endpoints exposed by the Pulsy Runtime / Service Gateway.
- Any pull request or agent attempting to import raw SQL drivers or Redis client libraries into the UI module must be rejected.

---

## 2. Device & Server Trust Boundaries

### 2.1 Discovered != Trusted
In a distributed home network, unauthenticated devices must not be trusted simply because they broadcast via mDNS or SSDP.

```text
[LAN Broadcast / mDNS]
          │
          ▼
   UNTRUSTED DISCOVERY
  (Can view device name)
          │
          ▼  User initiates pairing
   CHALLENGE / PIN EXCHANGE
  (6-digit short-lived PIN)
          │
          ▼  Verification succeeded
   TRUSTED NODE (dev_xxx)
  (Scoped JWT token issued)
```

1. **Discovery State:** The device is visible in the UI under "Available Nodes", but cannot read media, inspect watch history, or receive playback commands.
2. **Pairing State:** The user enters a short-lived 6-digit PIN displayed on the target screen.
3. **Authorized State:** A mutual cryptographic session token is generated and stored in the PostgreSQL `devices` registry.

### 2.2 Remote & Community Server Isolation
When connecting to a remote personal server or a shared community server:
- **No Control Plane Exposure:** The remote server does **not** gain read or write access to the user's personal Pulsy profile, playlists, or other servers.
- **Scoped Capabilities:** Tokens granted to remote servers are scoped strictly to the media library they host (`scope: ["media.read", "stream.read"]`).
- **Encrypted Transport:** All external connections must use TLS (HTTPS, WSS). Self-signed certificates on LAN servers require explicit user confirmation.

---

## 3. Capability-Based Permission Model

Pulsy uses fine-grained capabilities:

| Capability Scope | Description |
| :--- | :--- |
| `media.read` | View media catalog and metadata. |
| `media.stream` | Initiate playback streams and request byte ranges. |
| `media.download` | Download full media file for offline pocket storage. |
| `media.publish` | Upload or register new media into a library. |
| `playlist.write`| Create or edit user Packups. |
| `device.control`| Remote control playback (pause, seek, volume) on paired node. |
| `server.admin` | Modify server configuration, mount paths, and transcode settings. |

---

## 4. Android Platform Permissions & Storage

Pulsy adheres to the Google Play Developer Program policies and Android 14+ permission security:

### 4.1 Install-Time Permissions (Declared in Manifest)
- `android.permission.INTERNET`: Required for network streaming.
- `android.permission.ACCESS_NETWORK_STATE`: Required to detect WiFi vs Mobile data.
- `android.permission.VIBRATE`: Required for haptic pulse feedback.
- `android.permission.FOREGROUND_SERVICE`: Required for background media playback.
- `android.permission.FOREGROUND_SERVICE_MEDIA_PLAYBACK`: Required on Android 14+.

### 4.2 Runtime Permissions (Requested via Jetpack Compose)
- `android.permission.POST_NOTIFICATIONS`: Requested contextually when the user subscribes to alerts or initiates background downloads.
- `android.permission.RECORD_AUDIO`: Requested only inside the Studio Mini-App when voice recording or audio dubbing is explicitly triggered.

### 4.3 Zero-Permission Media Selection
- **Rule:** Never request broad `READ_EXTERNAL_STORAGE` or `READ_MEDIA_VIDEO` permissions for user uploads or icon customization.
- **Mandate:** Always use the Android Photo Picker (`ActivityResultContracts.PickVisualMedia`).
