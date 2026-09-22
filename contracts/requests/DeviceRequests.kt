package contracts.requests

import kotlinx.serialization.Serializable

@Serializable
data class DiscoverDevicesRequest(
    val timeoutMs: Long = 5000,
    val includeOffline: Boolean = false
)

@Serializable
data class PairDeviceRequest(
    val deviceId: String,
    val pairingCode: String? = null
)

@Serializable
data class UnpairDeviceRequest(
    val deviceId: String
)

@Serializable
data class ConnectDeviceRequest(
    val deviceId: String
)
