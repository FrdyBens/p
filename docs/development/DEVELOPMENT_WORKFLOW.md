# PULSY — DEVELOPMENT WORKFLOW & ENVIRONMENT SPECIFICATION

> **Version:** 1.0.0  
> **Status:** RATIFIED  
> **Scope:** Runtime Modes, n8n Development Bridge, Media Server, and Testing

---

## 1. Runtime Modes (Simulation vs. Production)

Pulsy supports two execution modes behind a single unified interface:

```text
               UI Layer (Jetpack Compose / ViewModel)
                                │
                                ▼
                   PulsyRuntime Interface
                   (runtime/gateway.ts or Kotlin)
                                │
                ┌───────────────┴───────────────┐
                ▼                               ▼
       MODE = "simulation"             MODE = "production"
                │                               │
                ▼                               ▼
         n8n Dev Bridge               Native Pulsy Backend
   (PostgreSQL 16 / Redis 7)       (High-performance Services)
                │                               │
                ▼                               ▼
      Real Test Media Server           Distributed CDN / Servers
```

### 1.1 The Golden Rule of Simulation
- **Simulation is NOT a second, incompatible architecture.**
- Simulation exposes the **exact same** Action IDs, models, contracts, errors, and event schemas as production.
- In simulation mode, the client communicates with the developer's local/cloud PostgreSQL instance (`pulsy_dev`) and Redis instance via the **n8n development bridge**.
- Fake static JSON files pretending to be a database are strictly forbidden for core persistence.

---

## 2. The n8n Development Bridge

### 2.1 Role & Architecture
- n8n acts as an HTTP/Webhook gateway that routes client requests directly to PostgreSQL and Redis.
- Enables rapid prototyping of database queries, schema iterations, and pub/sub events without writing boilerplate server code.

### 2.2 Security & Configuration
- **Rule:** Never hardcode n8n webhook URLs or database credentials into Kotlin or TypeScript source files.
- Credentials must be supplied via `.env`:
  ```bash
  PULSY_RUNTIME_MODE=simulation
  N8N_BRIDGE_BASE_URL=https://n8n.internal.pulsy.dev/webhook
  N8N_AUTH_BEARER_TOKEN=pulsy_dev_secret_token
  ```
- In Android code, accessed via `BuildConfig.N8N_BRIDGE_BASE_URL`.

---

## 3. Real Test Media Server Specification

### 3.1 Why a Real Media Server is Required
Testing playback requires verifying real streaming characteristics:
- HTTP `206 Partial Content` (Range header handling for video seeking).
- ExoPlayer buffer allocation and underrun recovery.
- MIME type negotiation (`video/mp4`, `application/x-mpegURL`, `audio/aac`).
- Subtitle track multiplexing (WebVTT / SRT).

### 3.2 Standard Development Test Media
The test media server hosts three standardized test assets:
1. `test_video_1080p.mp4`: 10-minute 1080p 60fps H.264 video with stereo AAC audio and chapter markers.
2. `test_short_pulse_9x16.mp4`: 30-second vertical video for testing the Pulses feed gesture physics.
3. `test_audio_stream.m4a`: 4-minute 320kbps AAC audio track with embedded ID3 metadata and album art.

---

## 4. Verification & Testing Workflow

When developing or modifying code:
1. Run local unit tests: `gradle :app:testDebugUnitTest`.
2. Compile and verify Android build: Call `compile_applet`.
3. Verify that `PAGE_MANIFEST.json` matches all Action IDs and contracts utilized.
