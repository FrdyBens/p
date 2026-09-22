package contracts.models

import contracts.enums.ServerStatus
import contracts.enums.ServerType
import kotlinx.serialization.Serializable

/**
 * Media server endpoint (personal NAS, community server, or cloud relay).
 *
 * Rules:
 * - discovered != trusted
 * - server admin != platform admin
 * - stream permission != download permission
 */
@Serializable
data class Server(
    val id: String,                 // srv_01j7b...
    val ownerId: String? = null,
    val name: String,               // "TrueNAS Core", "Pulsy Community Node"
    val serverType: ServerType,
    val status: ServerStatus = ServerStatus.ONLINE,
    val endpointUrl: String,        // https://nas.local:8443
    val isReachabilityConfirmed: Boolean = true,
    val authRequired: Boolean = true,
    val isTrusted: Boolean = false,
    val totalMediaCount: Long = 0,
    val capabilities: List<String> = emptyList(), // "direct_stream", "transcoding", "hls"
    val pingMs: Long? = null,
    val lastSeenAt: String,         // ISO-8601 UTC
    val createdAt: String,          // ISO-8601 UTC
    val updatedAt: String           // ISO-8601 UTC
)
