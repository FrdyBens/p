package contracts.enums

import kotlinx.serialization.Serializable

/**
 * Canonical Action IDs for all interactive user and service actions across Pulsy.
 * Dot-notated, deterministic, versionable, and machine-readable.
 *
 * Rules:
 * 1. UI interactions MUST reference these canonical Action IDs.
 * 2. Personality terms map cleanly to these action IDs without obfuscation.
 * 3. Accessibility labels remain standard and semantic regardless of personality labels.
 */
@Serializable
object ActionId {
    // Playback Actions (Personality -> Semantic)
    const val MEDIA_POP = "media.pop"                 // Play
    const val MEDIA_PULS = "media.puls"               // Pause
    const val MEDIA_PLOP = "media.plop"               // Stop
    const val MEDIA_SEEK = "media.seek"               // Seek to position
    const val MEDIA_PASS = "media.pass"               // Next Track
    const val MEDIA_PRIOR = "media.prior"             // Previous Track
    const val MEDIA_PULSE_PASS = "media.pulse_pass"   // Fast-Forward
    const val MEDIA_PULSE_PRIOR = "media.pulse_prior" // Rewind
    const val MEDIA_PACE = "media.pace"               // Playback Speed
    const val MEDIA_PUFF_UP = "media.puff_up"         // Fullscreen Toggle
    const val MEDIA_PACIFY = "media.pacify"           // Mute Audio
    const val MEDIA_VOLUME = "media.volume"           // Adjust Volume
    const val MEDIA_PERPETUAL = "media.perpetual"     // Repeat Toggle
    const val MEDIA_POTLUCK = "media.potluck"         // Shuffle Toggle
    const val MEDIA_SELECT_TRACK = "media.select_track" // Select Audio/Subtitle track

    // Media & Resolution Actions
    const val MEDIA_GET = "media.get"
    const val MEDIA_SCAN = "media.scan"
    const val MEDIA_REGISTER = "media.register"
    const val MEDIA_RESOLVE_SOURCE = "media.resolve_source"
    const val MEDIA_UPLOAD = "media.upload"
    const val MEDIA_PUBLISH = "media.publish"
    const val MEDIA_DELETE = "media.delete"

    // Social & Engagement Actions (Personality -> Semantic)
    const val SOCIAL_PUMP = "social.pump"             // Like
    const val SOCIAL_PUNCH = "social.punch"           // Dislike
    const val SOCIAL_PROPEL = "social.propel"         // Boost Creator
    const val SOCIAL_PAIR = "social.pair"             // Subscribe
    const val SOCIAL_PART = "social.part"             // Unsubscribe
    const val SOCIAL_PASS_PULSE = "social.pass_pulse" // Share
    const val SOCIAL_PATTER = "social.patter"         // Comments
    const val SOCIAL_PRATTLE = "social.prattle"       // Live Chat
    const val SOCIAL_PINNED_PATTER = "social.pinned_patter" // Pinned Comment

    // Playlist Actions (Packup)
    const val PLAYLIST_CREATE = "playlist.create"
    const val PLAYLIST_UPDATE = "playlist.update"
    const val PLAYLIST_DELETE = "playlist.delete"
    const val PLAYLIST_ITEM_ADD = "playlist.item.add"
    const val PLAYLIST_ITEM_REMOVE = "playlist.item.remove"
    const val PLAYLIST_ITEM_REORDER = "playlist.item.reorder"
    const val PLAYLIST_PACKUP = "playlist.packup"

    // Storage Actions (Pocket)
    const val STORAGE_POCKET = "storage.pocket"       // Download for Offline
    const val STORAGE_POCKET_DELETE = "storage.pocket_delete"

    // Device Actions
    const val DEVICE_DISCOVER = "device.discover"
    const val DEVICE_PAIR = "device.pair"
    const val DEVICE_UNPAIR = "device.unpair"
    const val DEVICE_CONNECT = "device.connect"
    const val DEVICE_DISCONNECT = "device.disconnect"
    const val DEVICE_HANDOFF = "device.handoff"

    // Server Actions
    const val SERVER_DISCOVER = "server.discover"
    const val SERVER_CONNECT = "server.connect"
    const val SERVER_DISCONNECT = "server.disconnect"
    const val SERVER_SCAN = "server.scan"

    // Library & Feed Actions
    const val LIBRARY_REFRESH = "library.refresh"
    const val LIBRARY_SCAN = "library.scan"
    const val FEED_GET = "feed.get"
    const val SEARCH_EXECUTE = "search.execute"
}
