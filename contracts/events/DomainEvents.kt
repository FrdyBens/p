package contracts.events

import kotlinx.serialization.Serializable

// Playback Domain Events
@Serializable
data class PlaybackStartedPayload(
    val sessionId: String,
    val mediaId: String,
    val sourceId: String,
    val targetDeviceId: String,
    val positionMs: Long
)

@Serializable
data class PlaybackPausedPayload(
    val sessionId: String,
    val mediaId: String,
    val positionMs: Long
)

@Serializable
data class PlaybackResumedPayload(
    val sessionId: String,
    val mediaId: String,
    val positionMs: Long
)

@Serializable
data class PlaybackPositionChangedPayload(
    val sessionId: String,
    val mediaId: String,
    val positionMs: Long,
    val durationMs: Long
)

@Serializable
data class PlaybackCompletedPayload(
    val sessionId: String,
    val mediaId: String
)

@Serializable
data class PlaybackHandoffRequestedPayload(
    val handoffId: String,
    val sourceDeviceId: String,
    val targetDeviceId: String,
    val sessionId: String,
    val mediaId: String
)

@Serializable
data class PlaybackHandoffCompletedPayload(
    val handoffId: String,
    val targetDeviceId: String,
    val mediaId: String,
    val positionMs: Long
)

// Media Domain Events
@Serializable
data class MediaCreatedPayload(
    val mediaId: String,
    val title: String,
    val mediaKind: String,
    val channelId: String
)

@Serializable
data class MediaUpdatedPayload(
    val mediaId: String,
    val fieldsUpdated: List<String>
)

@Serializable
data class MediaSourceDiscoveredPayload(
    val sourceId: String,
    val mediaId: String,
    val rawUri: String,
    val protocol: String
)

@Serializable
data class MediaSourceLostPayload(
    val sourceId: String,
    val mediaId: String,
    val reason: String? = null
)

// Device Domain Events
@Serializable
data class DeviceDiscoveredPayload(
    val deviceId: String,
    val name: String,
    val deviceType: String,
    val ipAddress: String
)

@Serializable
data class DevicePairedPayload(
    val deviceId: String,
    val userId: String?,
    val isTrusted: Boolean
)

@Serializable
data class DeviceOnlinePayload(
    val deviceId: String,
    val ipAddress: String
)

@Serializable
data class DeviceOfflinePayload(
    val deviceId: String
)

// Server Domain Events
@Serializable
data class ServerDiscoveredPayload(
    val serverId: String,
    val name: String,
    val serverType: String,
    val endpointUrl: String
)

@Serializable
data class ServerConnectedPayload(
    val serverId: String,
    val endpointUrl: String
)

@Serializable
data class ServerDisconnectedPayload(
    val serverId: String,
    val reason: String? = null
)

// Playlist & History Events
@Serializable
data class PlaylistCreatedPayload(
    val playlistId: String,
    val ownerId: String,
    val title: String
)

@Serializable
data class PlaylistUpdatedPayload(
    val playlistId: String,
    val itemCount: Int
)

@Serializable
data class HistoryUpdatedPayload(
    val historyEntryId: String,
    val userId: String,
    val mediaId: String,
    val lastPositionMs: Long,
    val completed: Boolean
)

@Serializable
data class NotificationCreatedPayload(
    val notificationId: String,
    val userId: String,
    val notificationType: String,
    val title: String
)
