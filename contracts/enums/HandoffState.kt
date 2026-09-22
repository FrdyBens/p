package contracts.enums

import kotlinx.serialization.Serializable

@Serializable
enum class HandoffState {
    REQUESTED,
    PREPARING,
    TRANSFERRING,
    COMPLETED,
    FAILED,
    CANCELLED
}
