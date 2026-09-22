// Playback Domain Events
export interface PlaybackStartedPayload {
  sessionId: string;
  mediaId: string;
  sourceId: string;
  targetDeviceId: string;
  positionMs: number;
}

export interface PlaybackPausedPayload {
  sessionId: string;
  mediaId: string;
  positionMs: number;
}

export interface PlaybackResumedPayload {
  sessionId: string;
  mediaId: string;
  positionMs: number;
}

export interface PlaybackPositionChangedPayload {
  sessionId: string;
  mediaId: string;
  positionMs: number;
  durationMs: number;
}

export interface PlaybackCompletedPayload {
  sessionId: string;
  mediaId: string;
}

export interface PlaybackHandoffRequestedPayload {
  handoffId: string;
  sourceDeviceId: string;
  targetDeviceId: string;
  sessionId: string;
  mediaId: string;
}

export interface PlaybackHandoffCompletedPayload {
  handoffId: string;
  targetDeviceId: string;
  mediaId: string;
  positionMs: number;
}

// Media Domain Events
export interface MediaCreatedPayload {
  mediaId: string;
  title: string;
  mediaKind: string;
  channelId: string;
}

export interface MediaUpdatedPayload {
  mediaId: string;
  fieldsUpdated: string[];
}

export interface MediaSourceDiscoveredPayload {
  sourceId: string;
  mediaId: string;
  rawUri: string;
  protocol: string;
}

export interface MediaSourceLostPayload {
  sourceId: string;
  mediaId: string;
  reason?: string | null;
}

// Device Domain Events
export interface DeviceDiscoveredPayload {
  deviceId: string;
  name: string;
  deviceType: string;
  ipAddress: string;
}

export interface DevicePairedPayload {
  deviceId: string;
  userId?: string | null;
  isTrusted: boolean;
}

export interface DeviceOnlinePayload {
  deviceId: string;
  ipAddress: string;
}

export interface DeviceOfflinePayload {
  deviceId: string;
}

// Server Domain Events
export interface ServerDiscoveredPayload {
  serverId: string;
  name: string;
  serverType: string;
  endpointUrl: string;
}

export interface ServerConnectedPayload {
  serverId: string;
  endpointUrl: string;
}

export interface ServerDisconnectedPayload {
  serverId: string;
  reason?: string | null;
}

// Playlist & History Events
export interface PlaylistCreatedPayload {
  playlistId: string;
  ownerId: string;
  title: string;
}

export interface PlaylistUpdatedPayload {
  playlistId: string;
  itemCount: number;
}

export interface HistoryUpdatedPayload {
  historyEntryId: string;
  userId: string;
  mediaId: string;
  lastPositionMs: number;
  completed: boolean;
}

export interface NotificationCreatedPayload {
  notificationId: string;
  userId: string;
  notificationType: string;
  title: string;
}
