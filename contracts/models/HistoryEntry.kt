package contracts.models

import kotlinx.serialization.Serializable

/**
 * Watch history entry referencing logical Media identity.
 * Survives file moves, renaming, and multi-source switching.
 */
@Serializable
data class HistoryEntry(
    val id: String,                 // his_01j7b...
    val userId: String,
    val mediaId: String,            // Canonical Media ID
    val deviceId: String? = null,   // Device where last played
    val lastPositionMs: Long,
    val durationMs: Long,
    val completed: Boolean = false,
    val startedAt: String,          // ISO-8601 UTC
    val lastPlayedAt: String        // ISO-8601 UTC
)
