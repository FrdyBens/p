package contracts.models

import kotlinx.serialization.Serializable

/**
 * Playback capabilities of a client or rendering device.
 */
@Serializable
data class PlaybackCapabilities(
    val supportedCodecs: List<String> = emptyList(), // "avc", "hevc", "vp9", "av1", "opus", "aac", "flac"
    val supportedContainers: List<String> = emptyList(), // "mp4", "mkv", "webm", "m3u8", "mpd"
    val maxResolutionWidth: Int = 1920,
    val maxResolutionHeight: Int = 1080,
    val supportsHdr: Boolean = false,
    val supportsByteRange: Boolean = true,
    val supportsAudioPassthrough: Boolean = false,
    val maxAudioChannels: Int = 2
)
