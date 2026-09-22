package contracts.enums

import kotlinx.serialization.Serializable

/**
 * Mapping between Pulsy's energetic "P" brand personality vocabulary,
 * underlying semantic meaning, canonical Action IDs, and accessibility labels.
 *
 * Adheres strictly to ADR-008:
 * - Visual Personality communicates brand vibrancy.
 * - Action IDs remain deterministic and semantic.
 * - Accessibility labels remain standard and accessible to screen readers.
 */
@Serializable
data class PersonalityTermMapping(
    val personalityName: String,
    val semanticName: String,
    val actionId: String,
    val accessibilityLabel: String,
    val category: String
)

object PersonalityVocabulary {
    val TERMS = listOf(
        PersonalityTermMapping("Pop", "Play", ActionId.MEDIA_POP, "Play", "Playback"),
        PersonalityTermMapping("Puls", "Pause", ActionId.MEDIA_PULS, "Pause", "Playback"),
        PersonalityTermMapping("Plop", "Stop", ActionId.MEDIA_PLOP, "Stop", "Playback"),
        PersonalityTermMapping("Pass", "Next Track", ActionId.MEDIA_PASS, "Next Track", "Playback"),
        PersonalityTermMapping("Prior", "Previous Track", ActionId.MEDIA_PRIOR, "Previous Track", "Playback"),
        PersonalityTermMapping("Pulse-Pass", "Fast Forward", ActionId.MEDIA_PULSE_PASS, "Fast Forward", "Playback"),
        PersonalityTermMapping("Pulse-Prior", "Rewind", ActionId.MEDIA_PULSE_PRIOR, "Rewind", "Playback"),
        PersonalityTermMapping("Pace", "Playback Speed", ActionId.MEDIA_PACE, "Playback Speed", "Playback"),
        PersonalityTermMapping("Puff-Up", "Fullscreen", ActionId.MEDIA_PUFF_UP, "Toggle Fullscreen", "Playback"),
        PersonalityTermMapping("Pacify", "Mute", ActionId.MEDIA_PACIFY, "Mute Audio", "Playback"),
        PersonalityTermMapping("Pumping-Slider", "Volume Control", ActionId.MEDIA_VOLUME, "Volume Control", "Playback"),
        PersonalityTermMapping("Perpetual", "Repeat", ActionId.MEDIA_PERPETUAL, "Repeat", "Playback"),
        PersonalityTermMapping("Potluck", "Shuffle", ActionId.MEDIA_POTLUCK, "Shuffle", "Playback"),
        PersonalityTermMapping("Pump", "Like", ActionId.SOCIAL_PUMP, "Like", "Social"),
        PersonalityTermMapping("Punch", "Dislike", ActionId.SOCIAL_PUNCH, "Dislike", "Social"),
        PersonalityTermMapping("Propel", "Boost", ActionId.SOCIAL_PROPEL, "Boost Creator", "Social"),
        PersonalityTermMapping("Pair", "Subscribe", ActionId.SOCIAL_PAIR, "Subscribe", "Social"),
        PersonalityTermMapping("Part", "Unsubscribe", ActionId.SOCIAL_PART, "Unsubscribe", "Social"),
        PersonalityTermMapping("Packup", "Playlist", ActionId.PLAYLIST_PACKUP, "Playlist", "Library"),
        PersonalityTermMapping("Pocket", "Download", ActionId.STORAGE_POCKET, "Download for Offline", "Storage"),
        PersonalityTermMapping("Pass-Pulse", "Share", ActionId.SOCIAL_PASS_PULSE, "Share", "Social"),
        PersonalityTermMapping("Patter", "Comments", ActionId.SOCIAL_PATTER, "Comments", "Social"),
        PersonalityTermMapping("Prattle", "Live Chat", ActionId.SOCIAL_PRATTLE, "Live Chat", "Social"),
        PersonalityTermMapping("Pinned-Patter", "Pinned Comment", ActionId.SOCIAL_PINNED_PATTER, "Pinned Comment", "Social")
    )
}
