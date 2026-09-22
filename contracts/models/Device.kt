package contracts.models

import contracts.enums.DeviceStatus
import contracts.enums.DeviceType
import kotlinx.serialization.Serializable

/**
 * Physical or client endpoint participating in the Pulsy distributed ecosystem.
 *
 * Rules:
 * - discovered != trusted (isTrusted defaults to false until explicit pairing)
 * - paired != full access
 */
@Serializable
data class Device(
    val id: String,                 // dev_01j7b...
    val userId: String? = null,
    val name: String,               // "Pixel 9 Pro", "Living Room TV"
    val deviceType: DeviceType,
    val status: DeviceStatus = DeviceStatus.ONLINE,
    val ipAddress: String,
    val port: Int,
    val isOnline: Boolean = true,
    val isTrusted: Boolean = false, // Paired and authorized
    val capabilities: List<String> = emptyList(), // "stream_sink", "remote_control", "4k_hdr"
    val appVersion: String? = null,
    val lastSeenAt: String,         // ISO-8601 UTC
    val createdAt: String,          // ISO-8601 UTC
    val updatedAt: String           // ISO-8601 UTC
)
