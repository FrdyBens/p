package contracts.requests

import kotlinx.serialization.Serializable

@Serializable
data class FeedRequest(
    val feedType: String = "pulses", // "pulses", "home", "trending", "subscriptions"
    val channelId: String? = null,
    val pagination: PaginationRequest? = null
)
