package contracts.models

import kotlinx.serialization.Serializable

/**
 * Multi-factor content fingerprint and identity evidence.
 * Enables associating physical files with existing logical Media IDs without duplicate creation.
 */
@Serializable
data class IdentityEvidence(
    val contentHashSha256: String,              // Primary cryptographic chunk hash
    val perceptualHash: String? = null,         // Audio/Video perceptual fingerprint
    val quickHash: String? = null,              // Fast header + footer probe hash
    val fileSize: Long,
    val durationMs: Long? = null,
    val externalProviderId: String? = null,     // e.g. "imdb:tt1234567" or "tmdb:98765"
    val containerFormat: String? = null,
    val matchConfidence: Float = 1.0f           // 0.0 to 1.0
)
