package contracts.enums

import kotlinx.serialization.Serializable

@Serializable
enum class SourceProtocol {
    FILE,
    SMB,
    HTTP,
    HTTPS,
    HLS,
    DASH,
    WEBRTC
}
