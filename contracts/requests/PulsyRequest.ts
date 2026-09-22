export interface PulsyRequest<T> {
  requestId: string; // req_01j7b...
  action: string; // Canonical ActionId
  timestamp: string; // ISO-8601 UTC
  clientVersion: string;
  deviceId?: string | null;
  payload: T;
}
