package contracts.models

import kotlinx.serialization.Serializable

/**
 * Lightweight real-time playback position payload.
 */
@Serializable
data class PlaybackPosition(
    val sessionId: String,
    val mediaId: String,
    val positionMs: Long,
    val durationMs: Long,
    val bufferedMs: Long = 0,
    val timestamp: String          // ISO-8601 UTC
)
