package contracts.models

import contracts.enums.SourceProtocol
import contracts.enums.SourceType
import kotlinx.serialization.Serializable

/**
 * Physical access location for a logical [Media].
 * A single Media entity can have 1 or multiple sources (phone local storage, LAN NAS, remote server).
 */
@Serializable
data class MediaSource(
    val id: String,                 // src_01j7b...
    val mediaId: String,            // Logical Media identity reference
    val deviceId: String? = null,   // Device ID if hosted locally on a device
    val serverId: String? = null,   // Server ID if hosted on a personal/community server
    val sourceType: SourceType,     // LOCAL_FILE, LAN_SERVER, PERSONAL_SERVER, COMMUNITY_SERVER, REMOTE_URL
    val protocol: SourceProtocol,   // FILE, SMB, HTTP, HTTPS, HLS, DASH, WEBRTC
    val rawUri: String,             // file:///storage/..., smb://..., or https://...
    val isOnline: Boolean = true,
    val priority: Int = 100,        // Lower number = higher priority
    val canStream: Boolean = true,
    val canDownload: Boolean = true,
    val lastVerifiedAt: String      // ISO-8601 UTC
)
