package contracts.models

import kotlinx.serialization.Serializable

/**
 * Audio track stream characteristics for multi-track playback.
 */
@Serializable
data class AudioTrack(
    val id: String,                 // "audio_en_1"
    val label: String,              // "English (5.1 Surround)"
    val language: String,           // "en"
    val codec: String,              // "ac-3", "opus", "aac"
    val channels: Int = 2,
    val isDefault: Boolean = false
)

/**
 * Subtitle and caption track specifications.
 */
@Serializable
data class SubtitleTrack(
    val id: String,                 // "sub_en_1"
    val label: String,              // "English [CC]"
    val language: String,           // "en"
    val format: String,             // "vtt", "srt", "ass"
    val isDefault: Boolean = false,
    val isForced: Boolean = false,
    val sourceUri: String? = null
)

/**
 * Video track specification for adaptive multi-stream configurations.
 */
@Serializable
data class VideoTrack(
    val id: String,
    val label: String,
    val width: Int,
    val height: Int,
    val fps: Float,
    val codec: String,
    val bitrateBps: Long,
    val isHdr: Boolean = false
)

/**
 * Chapter marker within a media timeline.
 */
@Serializable
data class Chapter(
    val id: String,
    val title: String,
    val startMs: Long,
    val endMs: Long,
    val thumbnailUri: String? = null
)
