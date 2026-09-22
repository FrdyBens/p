package contracts.enums

import kotlinx.serialization.Serializable

@Serializable
enum class NotificationType {
    SYSTEM,
    DEVICE_PAIRING,
    PLAYBACK_HANDOFF,
    CREATOR_PULSE,
    SOCIAL_PUMP,
    SOCIAL_PATTER,
    DOWNLOAD_STATUS
}
