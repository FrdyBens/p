package contracts.responses

import contracts.models.FeedItem
import kotlinx.serialization.Serializable

@Serializable
data class FeedResponse(
    val feedType: String,
    val items: List<FeedItem> = emptyList(),
    val pageInfo: PageInfo
)
