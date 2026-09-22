package contracts.responses

import contracts.errors.PulsyError
import kotlinx.serialization.Serializable

/**
 * Universal response envelope for all service operations across Pulsy.
 */
@Serializable
data class PulsyResponse<T>(
    val requestId: String,          // Matches corresponding PulsyRequest.requestId
    val action: String,             // ActionId of the operation executed
    val status: String,             // "OK" or "ERROR"
    val data: T? = null,            // Payload data if status is OK
    val error: PulsyError? = null,  // Canonical error if status is ERROR
    val timestamp: String           // ISO-8601 UTC
)
