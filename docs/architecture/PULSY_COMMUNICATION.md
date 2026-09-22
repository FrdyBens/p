# PULSY — COMMUNICATION ARCHITECTURE SPECIFICATION

> **Version:** 1.0.0  
> **Status:** RATIFIED  
> **Scope:** Inter-Process, Client-to-Runtime, and Network Service Protocols

---

## 1. Overview

To guarantee that dozens of independent AI agents can implement pages, services, and background workers without protocol collision, Pulsy enforces a strict, typed communication model:
1. **Action IDs**: Every client-initiated intent is identified by a dot-notated string.
2. **Standard Envelopes**: All requests and responses follow a canonical JSON envelope.
3. **Event Bus Conventions**: All asynchronous updates emit versioned, typed events.
4. **Structured Error Hierarchy**: Errors provide unambiguous machine-readable codes and recovery hints.

---

## 2. The Canonical Action ID System

Action IDs represent the verbs of the Pulsy ecosystem. They are grouped hierarchically: `<domain>.<subdomain>.<verb>`.

### 2.1 Media & Playback Actions

| Action ID | Personality Name | Description |
| :--- | :--- | :--- |
| `media.pop` | Pop | Start or resume playback of target media. |
| `media.puls` | Puls | Pause active playback. |
| `media.plop` | Plop | Stop playback and close session. |
| `media.seek` | Seek | Seek to timestamp in milliseconds. |
| `media.pass` | Pass | Skip to next item in active queue. |
| `media.prior` | Prior | Return to previous item in active queue. |
| `media.pulse_pass` | Pulse-Pass | Fast-forward by configured interval (e.g. 10s). |
| `media.pulse_prior`| Pulse-Prior | Rewind by configured interval (e.g. 10s). |
| `media.pace` | Pace | Set playback rate (0.25x, 0.5x, 1.0x, 1.25x, 1.5x, 2.0x). |
| `media.puff_up` | Puff-Up | Toggle full-screen display state. |
| `media.pacify` | Pacify | Toggle audio mute. |
| `media.volume` | Pumping-Slider | Set output volume (0.0 to 1.0). |
| `media.perpetual` | Perpetual | Cycle repeat mode (`OFF`, `ONE`, `ALL`). |
| `media.potluck` | Potluck | Toggle shuffle mode (`true` / `false`). |
| `media.peephole` | Peephole | Transition video player into Picture-in-Picture mode. |
| `media.scan` | Pocket-Scan | Trigger filesystem scan on target directory or mount. |
| `media.inspect` | Inspect | Fetch detailed metadata, source nodes, and variants. |

### 2.2 Social & Interaction Actions

| Action ID | Personality Name | Description |
| :--- | :--- | :--- |
| `social.pump` | Pump | Mark media as liked ("Pumped"). |
| `social.punch` | Punch | Mark media as disliked ("Punched"). |
| `social.propel` | Propel | Boost creator visibility or ranking. |
| `social.pair` | Pair | Subscribe to channel, creator, or server feed. |
| `social.part` | Part | Unsubscribe from channel or creator. |
| `social.pass_pulse`| Pass-Pulse | Share media link or initiate LAN playback handoff. |
| `social.patter` | Patter | Post a comment on media. |
| `social.prattle` | Prattle | Send a message to active live-stream chat. |
| `social.pinned_patter` | Pinned-Patter | Pin top comment (creator/admin only). |
| `monetization.pennies` | Pennies | Send monetary tip or token to creator. |
| `moderation.penalize` | Penalize | Report inappropriate content or spam. |

### 2.3 Playlist & Organization Actions

| Action ID | Personality Name | Description |
| :--- | :--- | :--- |
| `playlist.packup.create` | Create Packup | Create a new named playlist. |
| `playlist.packup.add` | Pack In | Add media to a playlist. |
| `playlist.packup.remove` | Unpack | Remove media from a playlist. |
| `playlist.packup.reorder`| Shuffle Pack | Change ordering of playlist items. |
| `playlist.postpone` | Postpone | Add to "Watch Later" smart playlist. |
| `storage.pocket` | Pocket | Download media for offline local playback. |

### 2.4 Device & Server Actions

| Action ID | Personality Name | Description |
| :--- | :--- | :--- |
| `device.discover` | Pulse-Discover | Probe LAN for discoverable Pulsy nodes. |
| `device.pair` | Pair-Node | Authenticate and pair with a remote device via PIN. |
| `device.handoff` | Beam-Pulse | Transfer active `PlaybackSession` to target device. |
| `server.register` | Anchor-Server | Register a personal or community media server. |
| `server.ping` | Pulse-Ping | Check connection health and latency of server. |
| `server.disconnect`| Sever-Node | De-register or disconnect server. |

---

## 3. Canonical Envelopes

### 3.1 Client Request Envelope (`PulsyRequest<T>`)

```json
{
  "requestId": "req_01j7b8a1c90001",
  "action": "media.seek",
  "version": "1.0",
  "timestamp": "2026-09-22T12:00:00.000Z",
  "actor": {
    "userId": "usr_01j7b001",
    "deviceId": "dev_pixel9_01"
  },
  "payload": {
    "sessionId": "ses_01j7b9921",
    "positionMs": 142050
  }
}
```

### 3.2 Server / Runtime Response Envelope (`PulsyResponse<T>`)

```json
{
  "requestId": "req_01j7b8a1c90001",
  "action": "media.seek",
  "status": "SUCCESS",
  "timestamp": "2026-09-22T12:00:00.045Z",
  "data": {
    "sessionId": "ses_01j7b9921",
    "positionMs": 142050,
    "playbackState": "PULS",
    "bufferedMs": 350000
  },
  "error": null
}
```

---

## 4. The Event System

Events are asynchronous notifications emitted when state transitions occur. They are dispatched over Redis Pub/Sub, WebSockets, or internal Android Coroutine Flows.

### 4.1 Canonical Event Format (`PulsyEvent<T>`)

```json
{
  "eventId": "evt_01j7b9x991",
  "eventName": "playback.position_changed",
  "version": "1.0",
  "timestamp": "2026-09-22T12:00:05.100Z",
  "source": {
    "subsystem": "playback",
    "deviceId": "dev_pixel9_01"
  },
  "payload": {
    "sessionId": "ses_01j7b9921",
    "mediaId": "media_01j7b6k28xfw8a01",
    "positionMs": 147000,
    "durationMs": 1420000,
    "state": "POP"
  }
}
```

### 4.2 Standard Event Catalog

- `media.created` — New media registered in logical catalog.
- `media.source.added` — New physical file or network URL associated with existing `MediaId`.
- `media.source.removed` — Physical file deleted or disconnected.
- `playback.started` — Playback session initiated (`Pop`).
- `playback.paused` — Playback paused (`Puls`).
- `playback.position_changed` — Periodic position sync (every 5s or on seek).
- `playback.completed` — Media playback finished (`Plop`).
- `device.discovered` — New LAN device detected.
- `device.paired` — Device pairing handshake completed.
- `playlist.updated` — Media added, removed, or reordered in a Packup.

---

## 5. Canonical Error Model

When a request cannot be fulfilled, `status` is set to `"ERROR"`, `data` is `null`, and the `error` object is populated.

```json
{
  "requestId": "req_01j7b8a1c90002",
  "action": "media.pop",
  "status": "ERROR",
  "timestamp": "2026-09-22T12:00:01.010Z",
  "data": null,
  "error": {
    "code": "MEDIA_SOURCE_UNAVAILABLE",
    "message": "The selected media file is on an offline NAS server.",
    "domain": "MEDIA",
    "retryable": true,
    "details": {
      "mediaId": "media_01j7b6k28xfw8a01",
      "sourceId": "src_nas_02",
      "targetDevice": "TrueNAS Core"
    }
  }
}
```

### 5.1 Standard Error Codes

| Code | Domain | Retryable | HTTP Equivalent | Description |
| :--- | :--- | :--- | :--- | :--- |
| `UNAUTHENTICATED` | AUTH | False | 401 | Missing or invalid auth token. |
| `PERMISSION_DENIED`| AUTH | False | 403 | Actor lacks required capability scope. |
| `NOT_FOUND` | CORE | False | 404 | Entity ID does not exist. |
| `MEDIA_UNAVAILABLE`| MEDIA | True | 404 | Logical media has no active sources. |
| `SOURCE_OFFLINE` | MEDIA | True | 503 | Source host is disconnected. |
| `PLAYBACK_DECODE_ERR`| PLAYBACK| False | 500 | Codec not supported on target device. |
| `DEVICE_UNREACHABLE`| DEVICE | True | 504 | LAN peer did not respond to probe. |
| `RATE_LIMITED` | NETWORK| True | 429 | Exceeded action request quota. |
| `CONFLICT` | DATA | False | 409 | Duplicate hash or unique key clash. |
| `INTERNAL_ERROR` | SYSTEM | True | 500 | Unexpected backend or runtime fault. |
