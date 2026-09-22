export interface PulsyEvent<T> {
  eventId: string; // evt_01j7b...
  eventType: string; // e.g. "playback.started"
  eventVersion: string;
  timestamp: string; // ISO-8601 UTC
  actorId?: string | null;
  subjectId: string;
  payload: T;
  metadata: Record<string, string>;
}
