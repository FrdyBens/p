package contracts.models

import contracts.enums.HandoffState
import kotlinx.serialization.Serializable

/**
 * Cross-device playback continuity and handoff payload.
 * Fully decoupled from hardware/OS specifics.
 */
@Serializable
data class HandoffPayload(
    val handoffId: String,          // hnd_01j7b...
    val sourceDeviceId: String,     // Device relinquishing playback
    val targetDeviceId: String,     // Device receiving playback
    val mediaId: String,            // Canonical Media ID
    val sourceId: String,           // Source ID
    val variantId: String? = null,
    val positionMs: Long,
    val durationMs: Long,
    val pace: Float = 1.0f,
    val volume: Float = 1.0f,
    val isMuted: Boolean = false,
    val audioTrackId: String? = null,
    val subtitleTrackId: String? = null,
    val state: HandoffState = HandoffState.REQUESTED,
    val queue: PlaybackQueue? = null,
    val timestamp: String           // ISO-8601 UTC
)
