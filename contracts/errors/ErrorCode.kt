package contracts.errors

import kotlinx.serialization.Serializable

@Serializable
enum class ErrorCode {
    AUTH_REQUIRED,
    FORBIDDEN,
    NOT_FOUND,
    INVALID_REQUEST,
    VALIDATION_FAILED,
    CONFLICT,
    MEDIA_UNAVAILABLE,
    SOURCE_UNAVAILABLE,
    DEVICE_OFFLINE,
    SERVER_UNAVAILABLE,
    PLAYBACK_FAILED,
    RATE_LIMITED,
    INTERNAL_ERROR
}
