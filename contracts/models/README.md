# Domain Models (`contracts/models/`)

Canonical domain entities for the Pulsy ecosystem.

## Core Models
- `Media.kt` / `Media.ts`: The logical media identity. Contains zero filesystem paths or URLs.
- `MediaSource.kt` / `MediaSource.ts`: Physical and network location endpoints where a Media can be accessed.
- `MediaVariant.kt` / `MediaVariant.ts`: Playable encoding, codec, bitrate, and resolution options.
- `MediaTracks.kt` / `MediaTracks.ts`: Multi-track specifications (`AudioTrack`, `SubtitleTrack`, `VideoTrack`, `Chapter`).
- `IdentityEvidence.kt` / `IdentityEvidence.ts`: Multi-factor content fingerprinting (cryptographic chunk hashing, duration, perceptual match).
- `User.kt` / `User.ts`: Safe public user profile model (no credentials or private secrets).
- `Persona.kt` / `Persona.ts`: Creator engagement metrics, bio, and live status.
- `Device.kt` / `Device.ts`: Client endpoints (`isTrusted` decoupled from discovery).
- `Server.kt` / `Server.ts`: Media serving nodes (personal NAS, community server, cloud relay).
- `PlaybackSession.kt` / `PlaybackSession.ts`: Universal active playback session state.
- `PlaybackPosition.kt` / `PlaybackPosition.ts`: Real-time timestamp synchronization.
- `PlaybackQueue.kt` / `PlaybackQueue.ts`: Ordered queue of playback items referencing canonical Media IDs.
- `PlaybackCapabilities.kt` / `PlaybackCapabilities.ts`: Device codec and rendering capabilities.
- `HandoffPayload.kt` / `HandoffPayload.ts`: Device-to-device session continuity payload.
- `Playlist.kt` & `PlaylistItem.kt` / `.ts`: User-curated packups referencing canonical Media IDs.
- `HistoryEntry.kt` / `HistoryEntry.ts`: Durable watch history decoupled from file location.
- `LibraryEntry.kt` / `LibraryEntry.ts`: User bookmarks and personal collection records.
- `Notification.kt` / `Notification.ts`: Inbox alert model.
- `SearchResult.kt` / `SearchResult.ts`: Universal search result entity.
- `FeedItem.kt` / `FeedItem.ts`: Dynamic feed entry wrapper.
- `MiniAppManifest.kt` / `MiniAppManifest.ts`: In-app mini application manifest contract.

## Invariant Rules
1. **Media Identity != Media Location**: Filesystem paths belong strictly to `MediaSource`.
2. **PostgreSQL is Source of Truth**: Durable models persist in Postgres; Redis handles ephemeral locks and caches.
3. **UI Isolation**: The UI never accesses databases directly.
