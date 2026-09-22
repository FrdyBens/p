export interface HistoryEntry {
  id: string; // his_01j7b...
  userId: string;
  mediaId: string; // Canonical Media ID
  deviceId?: string | null;
  lastPositionMs: number;
  durationMs: number;
  completed: boolean;
  startedAt: string; // ISO-8601 UTC
  lastPlayedAt: string; // ISO-8601 UTC
}
