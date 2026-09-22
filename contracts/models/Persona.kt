package contracts.models

import kotlinx.serialization.Serializable

/**
 * Creator and community profile attributes associated with a User.
 */
@Serializable
data class Persona(
    val userId: String,
    val bio: String? = null,
    val subscribersCount: Long = 0,
    val subscriptionsCount: Int = 0,
    val totalPumpsReceived: Long = 0,
    val primaryServerId: String? = null,
    val isLive: Boolean = false,
    val currentLiveMediaId: String? = null
)
