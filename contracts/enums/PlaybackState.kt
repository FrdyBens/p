package contracts.enums

import kotlinx.serialization.Serializable

@Serializable
enum class PlaybackState {
    IDLE,
    BUFFERING,
    POP,
    PULS,
    PLOP,
    COMPLETED,
    ERROR
}
