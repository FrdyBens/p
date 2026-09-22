package contracts.responses

import contracts.models.Server
import kotlinx.serialization.Serializable

@Serializable
data class ServerResponse(
    val server: Server
)

@Serializable
data class ServerListResponse(
    val servers: List<Server> = emptyList()
)
