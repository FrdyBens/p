package contracts.enums

import kotlinx.serialization.Serializable

@Serializable
enum class ServerStatus {
    ONLINE,
    OFFLINE,
    CONNECTING,
    UNREACHABLE,
    UNAUTHORIZED
}
