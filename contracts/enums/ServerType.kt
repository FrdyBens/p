package contracts.enums

import kotlinx.serialization.Serializable

@Serializable
enum class ServerType {
    PERSONAL_NAS,
    COMMUNITY,
    CLOUD_RELAY
}
