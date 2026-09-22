package contracts.requests

import contracts.enums.RepeatMode
import contracts.enums.SourceProtocol
import contracts.models.PlaybackCapabilities
import kotlinx.serialization.Serializable

@Serializable
data class PlayMediaRequest(
    val mediaId: String,            // Canonical Media ID
    val preferredSourceId: String? = null,
    val preferredVariantId: String? = null,
    val startPositionMs: Long = 0,
    val targetDeviceId: String? = null,
    val controllingDeviceId: String? = null
)

@Serializable
data class PauseMediaRequest(
    val sessionId: String
)

@Serializable
data class StopMediaRequest(
    val sessionId: String
)

@Serializable
data class SeekRequest(
    val sessionId: String,
    val positionMs: Long
)

@Serializable
data class PaceRequest(
    val sessionId: String,
    val pace: Float                 // Speed multiplier (e.g. 0.5, 1.0, 1.5, 2.0)
)

@Serializable
data class VolumeRequest(
    val sessionId: String,
    val volume: Float               // 0.0 to 1.0
)

@Serializable
data class PacifyRequest(
    val sessionId: String,
    val isMuted: Boolean
)

@Serializable
data class PerpetualRequest(
    val sessionId: String,
    val repeatMode: RepeatMode
)

@Serializable
data class PotluckRequest(
    val sessionId: String,
    val isShuffled: Boolean
)

@Serializable
data class SelectTrackRequest(
    val sessionId: String,
    val trackType: String,          // "AUDIO" or "SUBTITLE"
    val trackId: String? = null     // null to disable
)

@Serializable
data class HandoffRequest(
    val sourceDeviceId: String,
    val targetDeviceId: String,
    val sessionId: String,
    val mediaId: String,
    val positionMs: Long
)

@Serializable
data class ResolvePlaybackSourceRequest(
    val mediaId: String,
    val preferredProtocol: SourceProtocol? = null,
    val maxBitrateBps: Long? = null,
    val clientCapabilities: PlaybackCapabilities? = null
)
