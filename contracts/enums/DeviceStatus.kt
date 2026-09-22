package contracts.enums

import kotlinx.serialization.Serializable

@Serializable
enum class DeviceStatus {
    ONLINE,
    OFFLINE,
    UNPAIRED,
    PAIRING,
    BUSY
}
