package contracts.responses

import contracts.models.Device
import kotlinx.serialization.Serializable

@Serializable
data class DeviceResponse(
    val device: Device
)

@Serializable
data class DeviceListResponse(
    val devices: List<Device> = emptyList()
)

@Serializable
data class PairDeviceResponse(
    val deviceId: String,
    val isPaired: Boolean,
    val pairingStatus: String,
    val device: Device? = null
)
