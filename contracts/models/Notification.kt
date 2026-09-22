package contracts.models

import contracts.enums.NotificationType
import kotlinx.serialization.Serializable

/**
 * Action link attached to a notification.
 */
@Serializable
data class NotificationAction(
    val actionId: String,           // Canonical ActionId (e.g. "device.pair", "media.pop")
    val label: String,
    val payloadJson: String? = null
)

/**
 * Canonical notification model for user inbox alerts.
 */
@Serializable
data class Notification(
    val id: String,                 // notif_01j7b...
    val userId: String,
    val type: NotificationType,
    val title: String,
    val body: String,
    val isRead: Boolean = false,
    val targetRoute: String? = null,
    val actions: List<NotificationAction> = emptyList(),
    val createdAt: String           // ISO-8601 UTC
)
