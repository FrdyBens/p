package contracts.models

import contracts.enums.SearchResultType
import kotlinx.serialization.Serializable

/**
 * Universal search result item representing diverse domain entities
 * without forcing non-media results into fake Media objects.
 */
@Serializable
data class SearchResult(
    val entityId: String,           // ID of the referenced entity (mediaId, playlistId, userId, etc.)
    val resultType: SearchResultType,
    val title: String,
    val subtitle: String? = null,
    val thumbnailUri: String? = null,
    val score: Float = 1.0f,
    val badgeLabel: String? = null, // e.g. "4K", "Live", "Creator", "NAS"
    val metadata: Map<String, String> = emptyMap()
)
