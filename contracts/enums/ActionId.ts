/**
 * Canonical Action IDs for all interactive user and service actions across Pulsy.
 * Dot-notated, deterministic, versionable, and machine-readable.
 */
export const ActionId = {
  // Playback Actions (Personality -> Semantic)
  MEDIA_POP: "media.pop",                 // Play
  MEDIA_PULS: "media.puls",               // Pause
  MEDIA_PLOP: "media.plop",               // Stop
  MEDIA_SEEK: "media.seek",               // Seek to position
  MEDIA_PASS: "media.pass",               // Next Track
  MEDIA_PRIOR: "media.prior",             // Previous Track
  MEDIA_PULSE_PASS: "media.pulse_pass",   // Fast-Forward
  MEDIA_PULSE_PRIOR: "media.pulse_prior", // Rewind
  MEDIA_PACE: "media.pace",               // Playback Speed
  MEDIA_PUFF_UP: "media.puff_up",         // Fullscreen Toggle
  MEDIA_PACIFY: "media.pacify",           // Mute Audio
  MEDIA_VOLUME: "media.volume",           // Adjust Volume
  MEDIA_PERPETUAL: "media.perpetual",     // Repeat Toggle
  MEDIA_POTLUCK: "media.potluck",         // Shuffle Toggle
  MEDIA_SELECT_TRACK: "media.select_track", // Select Audio/Subtitle track

  // Media & Resolution Actions
  MEDIA_GET: "media.get",
  MEDIA_SCAN: "media.scan",
  MEDIA_REGISTER: "media.register",
  MEDIA_RESOLVE_SOURCE: "media.resolve_source",
  MEDIA_UPLOAD: "media.upload",
  MEDIA_PUBLISH: "media.publish",
  MEDIA_DELETE: "media.delete",

  // Social & Engagement Actions (Personality -> Semantic)
  SOCIAL_PUMP: "social.pump",             // Like
  SOCIAL_PUNCH: "social.punch",           // Dislike
  SOCIAL_PROPEL: "social.propel",         // Boost Creator
  SOCIAL_PAIR: "social.pair",             // Subscribe
  SOCIAL_PART: "social.part",             // Unsubscribe
  SOCIAL_PASS_PULSE: "social.pass_pulse", // Share
  SOCIAL_PATTER: "social.patter",         // Comments
  SOCIAL_PRATTLE: "social.prattle",       // Live Chat
  SOCIAL_PINNED_PATTER: "social.pinned_patter", // Pinned Comment

  // Playlist Actions (Packup)
  PLAYLIST_CREATE: "playlist.create",
  PLAYLIST_UPDATE: "playlist.update",
  PLAYLIST_DELETE: "playlist.delete",
  PLAYLIST_ITEM_ADD: "playlist.item.add",
  PLAYLIST_ITEM_REMOVE: "playlist.item.remove",
  PLAYLIST_ITEM_REORDER: "playlist.item.reorder",
  PLAYLIST_PACKUP: "playlist.packup",

  // Storage Actions (Pocket)
  STORAGE_POCKET: "storage.pocket",       // Download for Offline
  STORAGE_POCKET_DELETE: "storage.pocket_delete",

  // Device Actions
  DEVICE_DISCOVER: "device.discover",
  DEVICE_PAIR: "device.pair",
  DEVICE_UNPAIR: "device.unpair",
  DEVICE_CONNECT: "device.connect",
  DEVICE_DISCONNECT: "device.disconnect",
  DEVICE_HANDOFF: "device.handoff",

  // Server Actions
  SERVER_DISCOVER: "server.discover",
  SERVER_CONNECT: "server.connect",
  SERVER_DISCONNECT: "server.disconnect",
  SERVER_SCAN: "server.scan",

  // Library & Feed Actions
  LIBRARY_REFRESH: "library.refresh",
  LIBRARY_SCAN: "library.scan",
  FEED_GET: "feed.get",
  SEARCH_EXECUTE: "search.execute",
} as const;

export type ActionIdType = typeof ActionId[keyof typeof ActionId];
