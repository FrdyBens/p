package contracts.models

import contracts.enums.PlaybackState
import contracts.enums.RepeatMode
import kotlinx.serialization.Serializable

/**
 * Universal playback session model.
 *
 * Rules:
 * - Represents real-time playback state across devices and servers.
 * - Always references logical Media ID (mediaId).
 * - Centralizes control state (volume, pace, mute, repeat, tracks).
 */
@Serializable
data class PlaybackSession(
    val sessionId: String,          // ses_01j7b...
    val mediaId: String,            // Logical Media ID
    val activeSourceId: String,     // Physical/Network MediaSource ID
    val activeVariantId: String? = null,
    val targetDeviceId: String,     // Device rendering output
    val controllingDeviceId: String,// Device controlling playback
    val state: PlaybackState,       // IDLE, BUFFERING, POP, PULS, PLOP, COMPLETED, ERROR
    val positionMs: Long,
    val durationMs: Long,
    val volume: Float = 1.0f,       // 0.0 to 1.0
    val pace: Float = 1.0f,         // Speed multiplier (0.25 to 3.0)
    val isMuted: Boolean = false,
    val isFullscreen: Boolean = false,
    val repeatMode: RepeatMode = RepeatMode.OFF,
    val isShuffled: Boolean = false,
    val selectedAudioTrackId: String? = null,
    val selectedSubtitleTrackId: String? = null,
    val updatedAt: String           // ISO-8601 UTC
)
