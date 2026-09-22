export interface PlaybackPosition {
  sessionId: string;
  mediaId: string;
  positionMs: number;
  durationMs: number;
  bufferedMs: number;
  timestamp: string; // ISO-8601 UTC
}
