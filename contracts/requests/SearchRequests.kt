package contracts.requests

import contracts.enums.MediaKind
import contracts.enums.SearchResultType
import contracts.enums.SourceType
import kotlinx.serialization.Serializable

@Serializable
data class SearchFilters(
    val entityTypes: List<SearchResultType> = emptyList(),
    val mediaKinds: List<MediaKind> = emptyList(),
    val sourceTypes: List<SourceType> = emptyList(),
    val minDurationMs: Long? = null,
    val maxDurationMs: Long? = null,
    val channelId: String? = null,
    val tags: List<String> = emptyList(),
    val isOnlyBookmarked: Boolean = false
)

@Serializable
data class SearchSort(
    val field: String = "relevance", // "relevance", "publishedAt", "duration", "views", "pumpCount"
    val direction: String = "desc"   // "asc" or "desc"
)

@Serializable
data class SearchRequest(
    val query: String,
    val filters: SearchFilters? = null,
    val sort: SearchSort? = null,
    val pagination: PaginationRequest? = null
)
