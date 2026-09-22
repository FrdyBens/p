package contracts.requests

import kotlinx.serialization.Serializable

@Serializable
data class CreatePlaylistRequest(
    val title: String,
    val description: String? = null,
    val isPrivate: Boolean = true,
    val initialMediaIds: List<String> = emptyList()
)

@Serializable
data class UpdatePlaylistRequest(
    val playlistId: String,
    val title: String? = null,
    val description: String? = null,
    val isPrivate: Boolean? = null,
    val coverArtUri: String? = null
)

@Serializable
data class DeletePlaylistRequest(
    val playlistId: String
)

@Serializable
data class AddPlaylistItemRequest(
    val playlistId: String,
    val mediaId: String,            // Canonical Media ID
    val targetPositionOrder: Int? = null
)

@Serializable
data class RemovePlaylistItemRequest(
    val playlistId: String,
    val itemId: String
)

@Serializable
data class ReorderPlaylistRequest(
    val playlistId: String,
    val orderedItemIds: List<String>
)
