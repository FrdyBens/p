package contracts.models

import kotlinx.serialization.Serializable

/**
 * Item in the Pulses / Home dynamic feed.
 * Wraps canonical Media ID without duplicating or splitting the Media model.
 */
@Serializable
data class FeedItem(
    val feedItemId: String,         // fdi_01j7b...
    val mediaId: String,            // Reference to canonical Media
    val media: Media? = null,       // Optionally pre-hydrated canonical Media
    val rankScore: Float = 0.0f,
    val engagementPumps: Long = 0,  // Dynamic pump count
    val engagementPatters: Long = 0,// Dynamic comment count
    val isPumpedByUser: Boolean = false,
    val recommendedReason: String? = null // e.g. "Trending in Sci-Fi", "From your NAS"
)
