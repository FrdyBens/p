package contracts.models

import kotlinx.serialization.Serializable

/**
 * Canonical user account model.
 * Public and client-safe; contains ZERO credentials, passwords, or session tokens.
 */
@Serializable
data class User(
    val id: String,                 // e.g. "usr_01j7b..."
    val handle: String,             // e.g. "@cyberpulsar"
    val displayName: String,        // e.g. "Alex Pulsar"
    val avatarUrl: String? = null,
    val bannerUrl: String? = null,
    val isVerified: Boolean = false,
    val createdAt: String,          // ISO-8601 UTC
    val updatedAt: String           // ISO-8601 UTC
)
