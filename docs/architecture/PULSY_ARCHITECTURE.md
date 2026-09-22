# PULSY — SYSTEM ARCHITECTURE SPECIFICATION

> **Version:** 1.0.0  
> **Status:** RATIFIED  
> **Scope:** Entire Pulsy Distributed Ecosystem

---

## 1. Executive Summary

Pulsy is a distributed personal media ecosystem designed to unify local storage, personal media servers (e.g. NAS, home server), LAN devices, community servers, and creator-published streams into a seamless playback and discovery experience. 

Initially **Android-first**, Pulsy decouples the presentation layer from media storage, physical hardware, and backend infrastructure. The system is architected as **ONE unified control plane**, with client surfaces communicating exclusively through a contract-backed runtime abstraction.

---

## 2. High-Level System Architecture

```text
+-----------------------------------------------------------------------------------+
|                                 CLIENT SURFACES                                   |
|   +-----------+ +-----------+ +-----------+ +-----------+ +---------------------+ |
|   |    Pad    | |  Pulses   | |  Pocket   | |   Player  | | Studio / Mini-Apps  | |
|   |  (Home)   | |  (Shorts) | | (Library) | | (Overlay) | |      (Music)        | |
|   +-----------+ +-----------+ +-----------+ +-----------+ +---------------------+ |
+-----------------------------------------------------------------------------------+
                                          │
                        Typed Action IDs & UI State Flow
                                          │
                                          ▼
+-----------------------------------------------------------------------------------+
|                        PULSY RUNTIME & SERVICE GATEWAY                            |
|             (contracts/, core/, runtime/gateway.ts or Kotlin Client)              |
+-----------------------------------------------------------------------------------+
                       │                                    │
          (Development Mode)                       (Production Mode)
                       ▼                                    ▼
       +───────────────────────────────+     +───────────────────────────────+
       |       n8n DEV BRIDGE          |     |    PULSY NATIVE BACKEND       |
       |  - PostgreSQL Query Node      |     |  - High Performance Control   |
       |  - Redis Command Node         |     |  - gRPC / WebSocket / REST    |
       |  - Event Webhooks             |     |  - Media Dispatcher           |
       +───────────────────────────────+     +───────────────────────────────+
                       │                                    │
                       └──────────────────┬─────────────────┘
                                          │
                                          ▼
+───────────────────────────────────────────────────────────────────────────────────+
|                                PERSISTENCE & CACHE                                |
|  +─────────────────────────────────────────+ +──────────────────────────────────+ |
|  |     PostgreSQL 16.x (Source of Truth)   | |         Redis 7.x (Fast State)   | |
|  |  - Identities, Media, Devices, Servers  | |  - Presence, Session Locks       | |
|  |  - Playlists, Watch History, Permissions| |  - Active Queues, Ephemeral Keys | |
|  +─────────────────────────────────────────+ +──────────────────────────────────+ |
+───────────────────────────────────────────────────────────────────────────────────+
                                          ▲
                                          │
+───────────────────────────────────────────────────────────────────────────────────+
|                              MEDIA INGESTION & NODES                              |
|  +---------------------+ +----------------------+ +-----------------------------+ |
|  |  Local Storage / OS | | LAN / NAS / SMB Node | |   TEST MEDIA SERVER (Real)  | |
|  |  (Direct File Hash) | | (Discovery Daemon)   | |   (HLS, Byte-Range Seek)    | |
|  +---------------------+ +----------------------+ +-----------------------------+ |
+───────────────────────────────────────────────────────────────────────────────────+
```

---

## 3. Media Identity vs. Media Location (The Fundamental Tenet)

Traditional media apps couple a media record directly to a filesystem path (`/storage/emulated/0/Movies/film.mp4`) or a URL. If the user moves the file to another folder, reorganizes their NAS, or switches drives, their progress, metadata, and playlist associations are severed.

**Pulsy strictly separates Media Identity from Media Location.**

```text
+───────────────────────────────────────────────────────────────────────────────────+
|                           LOGICAL MEDIA (Canonical ID)                            |
|                             media_01j7b6k28xfw8a01                                |
|                                                                                   |
|  Title: "Cyberpunk Metropolis"                                                    |
|  Duration: 1420s                                                                  |
|  Canonical Fingerprint (SHA-256): e3b0c44298fc1c149afbf4c8996fb92427ae41e46...   |
|  Global Watch Progress: 720s (50%)                                                |
|  Pumped (Liked): true                                                             |
+───────────────────────────────────────────────────────────────────────────────────+
         │                                       │
         ▼                                       ▼
+───────────────────────────+         +───────────────────────────+
|   MEDIA SOURCE (Node A)   |         |   MEDIA SOURCE (Node B)   |
|   Source ID: src_local_01 |         |   Source ID: src_nas_02   |
|   Device: Pixel 9 Pro     |         |   Device: TrueNAS Core    |
|   URI: file:///storage/   |         |   URI: smb://nas.lan/pool/|
|        emulated/0/Movies/ |         |        media/Cyberpunk.mp4|
|        Cyberpunk.mp4      |         |   Access: LAN High-Speed  |
|   State: Online           |         |   State: Online           |
+───────────────────────────+         +───────────────────────────+
```

### 3.1 Domain Model Hierarchy
1. **Media (`Media`)**: The pure, logical entity. Contains universal metadata (title, overview, duration, cover art URI, tags, content rating) and canonical content hashes.
2. **MediaSource (`MediaSource`)**: A physical or network host that provides access to the media (e.g. Local Phone, NAS, Home Server, Remote Community Server).
3. **MediaLocation (`MediaLocation`)**: The protocol-specific address on a source (`file://...`, `smb://...`, `https://...`).
4. **MediaVariant (`MediaVariant`)**: Specific encodings or transcode resolutions (e.g., 4K HDR HEVC, 1080p SDR AVC, Audio-only AAC).
5. **PlaybackSession (`PlaybackSession`)**: An active or paused instance of media rendering on a target device. Holds real-time timestamp, buffer state, active audio track, and subtitle track.

---

## 4. Single Unified Control Plane

Pulsy has **ONE** authoritative backend service suite. Subsystems are not distinct siloed backends; they are modular domains within the single control plane:

| Subsystem | Responsibility |
| :--- | :--- |
| **Auth & Identity** | Cryptographic identity, public keys, session tokens, user personas. |
| **Media Service** | Ingestion, SHA-256 fingerprinting, metadata resolution, canonical media registry. |
| **Device Service** | Device registration, capability profiling, heartbeat, LAN pairing codes. |
| **Server Service** | Registration of personal/community media servers, remote gateway tunneling. |
| **Discovery Service**| LAN mDNS/SSDP probe listening, IP change detection, local peer exchange. |
| **Playback Service** | Authoritative playback session manager, cross-device handoff coordination. |
| **Playlist Service** | User-curated and algorithmic collections (`Packups`), smart watch-later (`Postpone`). |
| **History Service** | Granular playback checkpoints, resume points, play counts, completion flags. |
| **Notifications** | Real-time events, subscription uploads, device connection alerts. |
| **Search Service** | Unified index querying across local media, LAN servers, and online catalogs. |

---

## 5. Storage & Persistence Hierarchy

### 5.1 PostgreSQL 16.x (The Durable Anchor)
- **Role:** Permanent, relational system of record.
- **Database:** `pulsy_dev`
- **Schemas:** `auth`, `media`, `devices`, `servers`, `playlists`, `history`, `permissions`.
- **Integrity:** Strict foreign keys, unique constraint indexes on content hashes, transactional updates for state transitions.

### 5.2 Redis 7.x (The Ephemeral Accelerator)
- **Role:** Fast, in-memory state coordination.
- **Keyspaces:**
  - `presence:device:{device_id}` (TTL: 60s)
  - `session:playback:{session_id}` (Active position, buffer progress)
  - `lock:scan:{source_id}` (Prevent concurrent duplicate file indexing)
  - `cache:metadata:{hash}` (Hot metadata cache)

### 5.3 n8n Development Bridge
- In development/testing environments, n8n orchestrates flows between the client app and PostgreSQL/Redis.
- **Contract Rule:** The client codebase calls `PulsyRuntime.invoke(ActionId, Payload)`. Whether the backend target is n8n Webhook or native Node/Rust service is completely transparent to the caller.

### 5.4 Test Media Server
- A dedicated HTTP/HLS streaming daemon serving compliant media files (MP4, MKV, WebM, HLS).
- Enables accurate verification of:
  - Byte-range HTTP requests (`206 Partial Content`).
  - Adaptive bitrate stream switching.
  - Video seek latency and buffer exhaustion behavior.
  - Subtitle track multiplexing.

---

## 6. The Golden Path (End-to-End Execution Scenario)

All subsystem implementations must seamlessly support this end-to-end user journey:

```text
[1] SIGN IN
    User authenticates via Persona identity -> cryptographic device token issued.

[2] OPEN PULSY PAD (Home Feed)
    App launches -> queries runtime for recent media and highlights -> UI renders in <300ms.

[3] ADD LOCAL MEDIA
    User selects a directory or plugs in OTG drive -> `media.scan` initiated.

[4] HASH & IDENTIFY
    Scanner reads file header and computes SHA-256 chunk hash -> deduplication check.

[5] ISSUE CANONICAL MEDIA ID
    `MediaId` (`media_xxx`) assigned -> source registered as `file:///storage/...`

[6] POCKET / LIBRARY
    Media card appears in Library -> rich thumbnail generated -> metadata indexed.

[7] POP (PLAY)
    User taps Play (`media.pop`) -> Universal Player initializes ExoPlayer/Media3 -> stream starts.

[8] PULS & SEEK
    User pauses at 18:42 (`media.puls`) -> position written to Redis -> flushed to PostgreSQL history.

[9] APP RESTART & RESUME
    App terminates -> restarts later -> Home page displays "Continue Watching" at 18:42 -> instant resume.

[10] FILE MOVED ON DISK
    File is moved from `/storage/Movies/` to `/storage/Archive/` -> Rescan triggers.
    Hash matches -> Existing `MediaId` retained -> History, likes, and playlists remain untouched!

[11] DEVICE PAIRING & HANDOFF
    User turns on living room TV (Pulsy Android TV / Cast) -> Device discovered via LAN.
    User taps "Pass-Pulse" -> PlaybackSession seamlessly hands off: TV starts playing at 18:42.
```

---

## 7. Extensibility Model: Mini-Apps vs Extensions

| Dimension | Mini-App | Extension |
| :--- | :--- | :--- |
| **Definition** | A complete, self-contained sub-application hosted inside the Pulsy shell. | A background or UI hook modifying core behavior or enhancing a Mini-App. |
| **Examples** | `mini-apps/studio` (Video Editor), `mini-apps/music`, `mini-apps/podcast`. | `extensions/ai-captions`, `extensions/ffmpeg-transcode`, `extensions/yt-import`. |
| **UI** | Owns primary full-screen navigation and canvas. | Injects actions into existing action bars, sheets, or settings. |
| **Lifecycle** | Mounts and unmounts as an independent surface. | Loaded dynamically by the extension registry during startup. |
| **Manifest** | Requires `miniapp.json` with permissions & entry route. | Requires `extension.json` with hook declarations. |

---

## 8. Multi-Platform Progression

1. **Android (Target 1 - Current):**
   - Jetpack Compose, Material 3, ExoPlayer (Media3), Foreground Playback Service, Room local cache.
2. **Desktop (Target 2 - Future):**
   - Compose Multiplatform (Desktop) / Electron / Tauri.
3. **Web (Target 3 - Future):**
   - Modern reactive client connecting to the same unified control plane API.
