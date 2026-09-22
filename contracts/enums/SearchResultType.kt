package contracts.enums

import kotlinx.serialization.Serializable

@Serializable
enum class SearchResultType {
    MEDIA,
    PLAYLIST,
    USER,
    SERVER,
    CREATOR,
    MINI_APP
}
