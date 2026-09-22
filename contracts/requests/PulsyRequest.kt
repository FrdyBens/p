package contracts.requests

import kotlinx.serialization.Serializable

/**
 * Universal request envelope for all client-to-service operations across Pulsy.
 */
@Serializable
data class PulsyRequest<T>(
    val requestId: String,          // req_01j7b...
    val action: String,             // Canonical ActionId (e.g. "media.pop", "playlist.create")
    val timestamp: String,          // ISO-8601 UTC
    val clientVersion: String = "1.0.0",
    val deviceId: String? = null,   // Requesting device ID
    val payload: T
)
