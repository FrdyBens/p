package contracts.requests

import kotlinx.serialization.Serializable

@Serializable
data class DiscoverServersRequest(
    val scanLocalNetwork: Boolean = true,
    val timeoutMs: Long = 5000
)

@Serializable
data class ConnectServerRequest(
    val serverId: String,
    val endpointUrl: String? = null,
    val authToken: String? = null   // Transient connection credential, never persisted in Server model
)

@Serializable
data class DisconnectServerRequest(
    val serverId: String
)

@Serializable
data class ScanServerRequest(
    val serverId: String,
    val targetDirectory: String? = null
)
