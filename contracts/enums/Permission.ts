export const Permission = {
  // Media Permissions
  MEDIA_READ: "media.read",
  MEDIA_SEARCH: "media.search",
  MEDIA_PLAY: "media.play",
  MEDIA_CREATE: "media.create",
  MEDIA_DELETE: "media.delete",

  // Playlist Permissions
  PLAYLIST_READ: "playlist.read",
  PLAYLIST_WRITE: "playlist.write",

  // Device Permissions
  DEVICE_DISCOVER: "device.discover",
  DEVICE_PAIR: "device.pair",
  DEVICE_CONTROL: "device.control",

  // Server Permissions
  SERVER_READ: "server.read",
  SERVER_STREAM: "server.stream",
  SERVER_DOWNLOAD: "server.download",
  SERVER_ADMIN: "server.admin",

  // Storage Permissions
  STORAGE_READ: "storage.read",
  STORAGE_WRITE: "storage.write",
  STORAGE_DOWNLOAD: "storage.download",

  // Network Permissions
  NETWORK_REMOTE: "network.remote",
  NETWORK_LOCAL: "network.local",
} as const;

export type PermissionType = typeof Permission[keyof typeof Permission];
