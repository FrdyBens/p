package contracts.models

import kotlinx.serialization.Serializable

/**
 * Curated or algorithmic media playlist (Packup).
 */
@Serializable
data class Playlist(
    val id: String,                 // pack_01j7b...
    val ownerId: String,            // User ID
    val title: String,
    val description: String? = null,
    val isPrivate: Boolean = true,
    val itemCount: Int = 0,
    val coverArtUri: String? = null,
    val createdAt: String,          // ISO-8601 UTC
    val updatedAt: String           // ISO-8601 UTC
)

/**
 * Reference item in a playlist pointing strictly to a canonical [Media].
 */
@Serializable
data class PlaylistItem(
    val id: String,                 // itm_01j7b...
    val playlistId: String,
    val mediaId: String,            // Canonical Media ID
    val positionOrder: Int,
    val addedAt: String             // ISO-8601 UTC
)
