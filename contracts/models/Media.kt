package contracts.models

import contracts.enums.MediaKind
import kotlinx.serialization.Serializable

/**
 * Canonical logical media entity.
 *
 * CRITICAL ARCHITECTURAL RULE:
 * MEDIA IDENTITY != MEDIA LOCATION
 * This model contains ZERO filesystem paths, local disk paths, or server URLs.
 * Physical storage and streaming endpoints are decoupled into [MediaSource] and [MediaVariant].
 */
@Serializable
data class Media(
    val id: String,                 // media_01j7b6k28xfw8a01
    val title: String,
    val overview: String? = null,
    val mediaKind: MediaKind,
    val durationMs: Long,
    val thumbnailUri: String,
    val canonicalHash: String,      // Content fingerprint (e.g. SHA-256 chunk hash)
    val channelId: String,          // usr_... or author identity
    val channelTitle: String,
    val publishedAt: String,        // ISO-8601 UTC
    val viewsCount: Long = 0,
    val pumpCount: Long = 0,        // Likes (Pump)
    val punchCount: Long = 0,       // Dislikes (Punch)
    val sourceCount: Int = 1,
    val tags: List<String> = emptyList(),
    val createdAt: String,          // ISO-8601 UTC
    val updatedAt: String           // ISO-8601 UTC
)
