# PULSY — DATA CONTRACTS SPECIFICATION

> **Version:** 1.0.0  
> **Status:** RATIFIED  
> **Canonical Root:** `/contracts/`

---

## 1. Overview

Contracts form the binding agreement between all frontend surfaces, runtime abstractions, backend services, and background workers. In a multi-agent ecosystem, **no agent may invent private variants of domain models**.

All data models must be defined under `contracts/` with standard TypeScript and Kotlin `@Serializable` definitions.

```text
contracts/
├── enums/         # Canonical enumerations (PlaybackState, MediaType, etc.)
├── errors/        # Standard error shapes and domain codes
├── events/        # Async event schemas (PulsyEvent<T>)
├── models/        # Canonical entities (Media, User, Device, Playlist, etc.)
├── requests/      # Action request schemas (PulsyRequest<T>)
└── responses/     # Action response schemas (PulsyResponse<T>)
```

---

## 2. Canonical Core Models

### 2.1 User & Identity
Represents the account, credentials, and user profile within the ecosystem.

```kotlin
@Serializable
data class User(
    val id: String,                 // usr_01j7b...
    val handle: String,             // @cyberpulsar
    val displayName: String,        // "Alex Pulsar"
    val avatarUrl: String?,
    val bannerUrl: String?,
    val isVerified: Boolean = false,
    val createdAt: String,          // ISO-8601
    val updatedAt: String
)

@Serializable
data class Persona(
    val userId: String,
    val bio: String?,
    val subscribersCount: Long = 0,
    val subscriptionsCount: Int = 0,
    val totalPumpsReceived: Long = 0,
    val primaryServerId: String? = null
)
```

### 2.2 Media, MediaSource & MediaVariant
The decoupled media entity architecture:

```kotlin
@Serializable
enum class MediaType { VIDEO, AUDIO, SHORT_PULSE, LIVE_STREAM, PODCAST }

@Serializable
data class Media(
    val id: String,                 // media_01j7b6k28xfw8a01
    val title: String,
    val overview: String? = null,
    val mediaType: MediaType,
    val durationMs: Long,
    val thumbnailUri: String,
    val canonicalHash: String,      // SHA-256 chunk hash
    val channelId: String,          // usr_...
    val channelTitle: String,
    val publishedAt: String,
    val viewsCount: Long = 0,
    val pumpCount: Long = 0,        // Likes
    val punchCount: Long = 0,       // Dislikes
    val sourceCount: Int = 1,
    val tags: List<String> = emptyList()
)

@Serializable
enum class SourceProtocol { FILE, SMB, HTTP, HTTPS, HLS, WEBRTC }

@Serializable
data class MediaSource(
    val id: String,                 // src_01j7b...
    val mediaId: String,
    val deviceId: String?,          // Host device if local/LAN
    val serverId: String?,          // Host server if managed server
    val protocol: SourceProtocol,
    val rawUri: String,             // file:///storage/... or https://...
    val isOnline: Boolean = true,
    val priority: Int = 100,        // Lower is preferred
    val lastVerifiedAt: String
)

@Serializable
data class MediaVariant(
    val id: String,                 // var_01j7b...
    val mediaSourceId: String,
    val qualityLabel: String,       // "1080p60", "4K HDR", "320kbps MP3"
    val resolutionWidth: Int? = null,
    val resolutionHeight: Int? = null,
    val bitrateBps: Long,
    val codec: String,              // "avc1.640028", "vp9", "hvc1"
    val containerFormat: String     // "mp4", "mkv", "webm", "m3u8"
)
```

### 2.3 Device & Server
Hardware nodes participating in the Pulsy distributed ecosystem.

```kotlin
@Serializable
enum class DeviceType { PHONE, TABLET, TV, DESKTOP, CAR, EMBEDDED }

@Serializable
data class Device(
    val id: String,                 // dev_01j7b...
    val name: String,               // "Pixel 9 Pro", "Living Room Shield TV"
    val deviceType: DeviceType,
    val ipAddress: String,
    val port: Int,
    val isOnline: Boolean,
    val isTrusted: Boolean,         // Paired and authorized
    val lastSeenAt: String
)

@Serializable
enum class ServerType { PERSONAL_NAS, COMMUNITY, CLOUD_RELAY }

@Serializable
data class Server(
    val id: String,                 // srv_01j7b...
    val name: String,               // "TrueNAS Core", "Home Plex/Pulsy Node"
    val serverType: ServerType,
    val endpointUrl: String,        // https://nas.local:8443
    val isReachabilityConfirmed: Boolean,
    val authRequired: Boolean = true,
    val totalMediaCount: Long = 0
)
```

### 2.4 Playback & Session Models

```kotlin
@Serializable
enum class PlaybackState { IDLE, BUFFERING, POP, PULS, PLOP, COMPLETED, ERROR }

@Serializable
data class PlaybackSession(
    val sessionId: String,          // ses_01j7b...
    val mediaId: String,
    val activeSourceId: String,
    val activeVariantId: String?,
    val targetDeviceId: String,     // Device rendering audio/video
    val controllingDeviceId: String,// Device holding remote control
    val state: PlaybackState,
    val positionMs: Long,
    val durationMs: Long,
    val volume: Float = 1.0f,
    val pace: Float = 1.0f,
    val isMuted: Boolean = false,
    val updatedAt: String
)
```

### 2.5 Playlists & History

```kotlin
@Serializable
data class Playlist(
    val id: String,                 // pack_01j7b...
    val ownerId: String,
    val title: String,              // "Synthwave Night Drive"
    val description: String? = null,
    val isPrivate: Boolean = true,
    val itemCount: Int = 0,
    val coverArtUri: String? = null,
    val updatedAt: String
)

@Serializable
data class PlaylistItem(
    val id: String,
    val playlistId: String,
    val mediaId: String,
    val positionOrder: Int,
    val addedAt: String
)

@Serializable
data class HistoryEntry(
    val id: String,
    val userId: String,
    val mediaId: String,
    val lastPositionMs: Long,
    val durationMs: Long,
    val completed: Boolean = false,
    val lastWatchedAt: String
)
```

---

## 3. Contract Versioning & Rules

1. **Semantic Versioning**: All contracts follow `v<Major>.<Minor>`. Breaking changes (field removal, field type modification) require a major version bump.
2. **Backward Compatibility**: New fields added to contracts must be optional (nullable) or provide a default value.
3. **No Redundant Aliases**: There is strictly one `Media` model. Pages must not create `FeedItem` or `ShortsCard` when the backing entity is a `Media` object. UI display state wrappers are permitted, but must wrap the canonical model.
