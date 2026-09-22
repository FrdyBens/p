package contracts.models

import kotlinx.serialization.Serializable

/**
 * Playable encoding/container variant associated with a [MediaSource].
 * Describes codec, resolution, bitrate, and container characteristics.
 */
@Serializable
data class MediaVariant(
    val id: String,                 // var_01j7b...
    val mediaId: String,            // Logical Media identity reference
    val sourceId: String,           // Source providing this variant
    val qualityLabel: String,       // "1080p60", "4K HDR", "320kbps MP3"
    val resolutionWidth: Int? = null,
    val resolutionHeight: Int? = null,
    val bitrateBps: Long,
    val videoCodec: String? = null, // "avc1.640028", "vp9", "av01"
    val audioCodec: String? = null, // "mp4a.40.2", "opus", "flac"
    val containerFormat: String,    // "mp4", "mkv", "webm", "m3u8"
    val fps: Float? = null,
    val isHdr: Boolean = false,
    val sizeBytes: Long? = null
)
