package contracts.models

import kotlinx.serialization.Serializable

/**
 * User library record linking a canonical Media to the personal collection.
 */
@Serializable
data class LibraryEntry(
    val id: String,                 // lib_01j7b...
    val userId: String,
    val mediaId: String,            // Canonical Media ID
    val isBookmarked: Boolean = true,
    val isDownloaded: Boolean = false,
    val localDownloadPath: String? = null,
    val userRating: Int? = null,    // 1-5 or null
    val customTags: List<String> = emptyList(),
    val addedAt: String,            // ISO-8601 UTC
    val updatedAt: String           // ISO-8601 UTC
)
