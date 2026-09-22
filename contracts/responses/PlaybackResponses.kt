package contracts.responses

import contracts.enums.HandoffState
import contracts.enums.SourceProtocol
import contracts.models.PlaybackSession
import kotlinx.serialization.Serializable

@Serializable
data class PlaybackSessionResponse(
    val session: PlaybackSession
)

@Serializable
data class ResolvePlaybackSourceResponse(
    val mediaId: String,
    val sourceId: String,
    val variantId: String? = null,
    val playableUrl: String,
    val headers: Map<String, String> = emptyMap(),
    val protocol: SourceProtocol,
    val mimeType: String,
    val durationMs: Long,
    val rangeSupport: Boolean = true
)

@Serializable
data class HandoffResponse(
    val handoffId: String,
    val state: HandoffState,
    val targetDeviceId: String,
    val message: String? = null
)
