package contracts.events

import kotlinx.serialization.Serializable

/**
 * Universal event envelope for all asynchronous domain and lifecycle events.
 */
@Serializable
data class PulsyEvent<T>(
    val eventId: String,            // evt_01j7b...
    val eventType: String,          // e.g. "playback.started", "media.source.discovered"
    val eventVersion: String = "1.0.0",
    val timestamp: String,          // ISO-8601 UTC
    val actorId: String? = null,    // User or device initiating the event
    val subjectId: String,          // Primary entity ID (mediaId, sessionId, deviceId, etc.)
    val payload: T,
    val metadata: Map<String, String> = emptyMap()
)
