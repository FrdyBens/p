package contracts.enums

import kotlinx.serialization.Serializable

@Serializable
enum class SourceType {
    LOCAL_FILE,
    LAN_SERVER,
    PERSONAL_SERVER,
    COMMUNITY_SERVER,
    REMOTE_URL
}
