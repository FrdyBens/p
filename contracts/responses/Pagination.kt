package contracts.responses

import kotlinx.serialization.Serializable

/**
 * Standard page metadata for cursor-based pagination.
 */
@Serializable
data class PageInfo(
    val nextCursor: String? = null,
    val prevCursor: String? = null,
    val hasMore: Boolean = false,
    val totalCount: Long? = null
)

/**
 * Generic paginated response wrapper.
 */
@Serializable
data class PaginationResponse<T>(
    val items: List<T> = emptyList(),
    val pageInfo: PageInfo
)
