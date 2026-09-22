package contracts.errors

import kotlinx.serialization.Serializable

/**
 * Standard machine-readable error envelope returned by all Pulsy services and runtime APIs.
 */
@Serializable
data class PulsyError(
    val code: ErrorCode,
    val message: String,
    val details: Map<String, String>? = null,
    val requestId: String? = null,
    val retryable: Boolean = false,
    val timestamp: String // ISO-8601 UTC
)
