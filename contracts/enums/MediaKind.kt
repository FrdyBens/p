package contracts.enums

import kotlinx.serialization.Serializable

@Serializable
enum class MediaKind {
    VIDEO,
    AUDIO,
    SHORT_PULSE,
    LIVE_STREAM,
    PODCAST
}
