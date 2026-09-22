package contracts.models

import contracts.enums.RepeatMode
import kotlinx.serialization.Serializable

/**
 * Single item inside a playback queue, referencing logical Media ID.
 */
@Serializable
data class PlaybackItem(
    val mediaId: String,            // Logical Media ID
    val title: String,
    val durationMs: Long,
    val thumbnailUri: String,
    val artistOrChannel: String,
    val preferredSourceId: String? = null
)

/**
 * Universal playback queue state.
 */
@Serializable
data class PlaybackQueue(
    val queueId: String,            // que_01j7b...
    val currentIndex: Int = 0,
    val items: List<PlaybackItem> = emptyList(),
    val repeatMode: RepeatMode = RepeatMode.OFF,
    val isShuffled: Boolean = false
)
