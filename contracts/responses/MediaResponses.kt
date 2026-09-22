package contracts.responses

import contracts.models.Media
import contracts.models.MediaSource
import kotlinx.serialization.Serializable

@Serializable
data class MediaResponse(
    val media: Media,
    val sources: List<MediaSource> = emptyList(),
    val activeSourceId: String? = null
)

@Serializable
data class MediaListResponse(
    val items: List<Media> = emptyList(),
    val pageInfo: PageInfo
)

@Serializable
data class MediaScanResponse(
    val scannedCount: Int,
    val matchedExistingCount: Int,
    val newCreatedCount: Int,
    val candidateSources: List<MediaSource> = emptyList()
)

@Serializable
data class MediaRegistrationResponse(
    val media: Media,
    val source: MediaSource,
    val isExistingIdentity: Boolean // True if content matched an existing logical Media
)

@Serializable
data class UploadResponse(
    val uploadId: String,
    val targetUrl: String,
    val headers: Map<String, String> = emptyMap()
)

@Serializable
data class PublishResponse(
    val mediaId: String,
    val success: Boolean,
    val message: String? = null
)
