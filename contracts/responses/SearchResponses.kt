package contracts.responses

import contracts.models.SearchResult
import kotlinx.serialization.Serializable

@Serializable
data class SearchFacet(
    val category: String,
    val value: String,
    val count: Long
)

@Serializable
data class SearchResponse(
    val query: String,
    val results: List<SearchResult> = emptyList(),
    val facets: List<SearchFacet> = emptyList(),
    val pageInfo: PageInfo
)
