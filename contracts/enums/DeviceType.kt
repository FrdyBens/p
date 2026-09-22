package contracts.enums

import kotlinx.serialization.Serializable

@Serializable
enum class DeviceType {
    PHONE,
    TABLET,
    TV,
    DESKTOP,
    CAR,
    EMBEDDED,
    BROWSER
}
