package contracts.requests

import contracts.enums.MediaKind
import contracts.enums.SourceProtocol
import contracts.enums.SourceType
import contracts.models.IdentityEvidence
import kotlinx.serialization.Serializable

@Serializable
data class GetMediaRequest(
    val mediaId: String
)

@Serializable
data class MediaScanRequest(
    val path: String,
    val deviceId: String? = null,
    val serverId: String? = null,
    val recursive: Boolean = true
)

@Serializable
data class MediaRegistrationRequest(
    val mediaId: String? = null,    // If known, otherwise auto-matched via evidence
    val title: String,
    val overview: String? = null,
    val mediaKind: MediaKind,
    val durationMs: Long,
    val thumbnailUri: String,
    val rawUri: String,
    val protocol: SourceProtocol,
    val sourceType: SourceType,
    val evidence: IdentityEvidence,
    val deviceId: String? = null,
    val serverId: String? = null,
    val tags: List<String> = emptyList()
)

@Serializable
data class UploadRequest(
    val mediaId: String? = null,
    val fileName: String,
    val fileSize: Long,
    val mimeType: String,
    val sha256Checksum: String
)

@Serializable
data class PublishRequest(
    val mediaId: String,
    val title: String,
    val overview: String? = null,
    val mediaKind: MediaKind,
    val tags: List<String> = emptyList(),
    val isPublic: Boolean = true
)
