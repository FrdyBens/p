export interface PersonalityTermMapping {
  personalityName: string;
  semanticName: string;
  actionId: string;
  accessibilityLabel: string;
  category: string;
}

export const PersonalityVocabulary: readonly PersonalityTermMapping[] = [
  { personalityName: "Pop", semanticName: "Play", actionId: "media.pop", accessibilityLabel: "Play", category: "Playback" },
  { personalityName: "Puls", semanticName: "Pause", actionId: "media.puls", accessibilityLabel: "Pause", category: "Playback" },
  { personalityName: "Plop", semanticName: "Stop", actionId: "media.plop", accessibilityLabel: "Stop", category: "Playback" },
  { personalityName: "Pass", semanticName: "Next Track", actionId: "media.pass", accessibilityLabel: "Next Track", category: "Playback" },
  { personalityName: "Prior", semanticName: "Previous Track", actionId: "media.prior", accessibilityLabel: "Previous Track", category: "Playback" },
  { personalityName: "Pulse-Pass", semanticName: "Fast Forward", actionId: "media.pulse_pass", accessibilityLabel: "Fast Forward", category: "Playback" },
  { personalityName: "Pulse-Prior", semanticName: "Rewind", actionId: "media.pulse_prior", accessibilityLabel: "Rewind", category: "Playback" },
  { personalityName: "Pace", semanticName: "Playback Speed", actionId: "media.pace", accessibilityLabel: "Playback Speed", category: "Playback" },
  { personalityName: "Puff-Up", semanticName: "Fullscreen", actionId: "media.puff_up", accessibilityLabel: "Toggle Fullscreen", category: "Playback" },
  { personalityName: "Pacify", semanticName: "Mute", actionId: "media.pacify", accessibilityLabel: "Mute Audio", category: "Playback" },
  { personalityName: "Pumping-Slider", semanticName: "Volume Control", actionId: "media.volume", accessibilityLabel: "Volume Control", category: "Playback" },
  { personalityName: "Perpetual", semanticName: "Repeat", actionId: "media.perpetual", accessibilityLabel: "Repeat", category: "Playback" },
  { personalityName: "Potluck", semanticName: "Shuffle", actionId: "media.potluck", accessibilityLabel: "Shuffle", category: "Playback" },
  { personalityName: "Pump", semanticName: "Like", actionId: "social.pump", accessibilityLabel: "Like", category: "Social" },
  { personalityName: "Punch", semanticName: "Dislike", actionId: "social.punch", accessibilityLabel: "Dislike", category: "Social" },
  { personalityName: "Propel", semanticName: "Boost", actionId: "social.propel", accessibilityLabel: "Boost Creator", category: "Social" },
  { personalityName: "Pair", semanticName: "Subscribe", actionId: "social.pair", accessibilityLabel: "Subscribe", category: "Social" },
  { personalityName: "Part", semanticName: "Unsubscribe", actionId: "social.part", accessibilityLabel: "Unsubscribe", category: "Social" },
  { personalityName: "Packup", semanticName: "Playlist", actionId: "playlist.packup", accessibilityLabel: "Playlist", category: "Library" },
  { personalityName: "Pocket", semanticName: "Download", actionId: "storage.pocket", accessibilityLabel: "Download for Offline", category: "Storage" },
  { personalityName: "Pass-Pulse", semanticName: "Share", actionId: "social.pass_pulse", accessibilityLabel: "Share", category: "Social" },
  { personalityName: "Patter", semanticName: "Comments", actionId: "social.patter", accessibilityLabel: "Comments", category: "Social" },
  { personalityName: "Prattle", semanticName: "Live Chat", actionId: "social.prattle", accessibilityLabel: "Live Chat", category: "Social" },
  { personalityName: "Pinned-Patter", semanticName: "Pinned Comment", actionId: "social.pinned_patter", accessibilityLabel: "Pinned Comment", category: "Social" },
];
