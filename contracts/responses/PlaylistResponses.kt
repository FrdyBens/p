package contracts.responses

import contracts.models.Playlist
import contracts.models.PlaylistItem
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistResponse(
    val playlist: Playlist,
    val items: List<PlaylistItem> = emptyList()
)

@Serializable
data class PlaylistListResponse(
    val items: List<Playlist> = emptyList(),
    val pageInfo: PageInfo
)
