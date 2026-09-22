package contracts.requests

import kotlinx.serialization.Serializable

/**
 * Canonical cursor-based pagination request model.
 */
@Serializable
data class PaginationRequest(
    val cursor: String? = null,
    val limit: Int = 20,
    val direction: String = "next" // "next" or "prev"
)
