export interface User {
  id: string; // e.g. "usr_01j7b..."
  handle: string; // e.g. "@cyberpulsar"
  displayName: string; // e.g. "Alex Pulsar"
  avatarUrl?: string | null;
  bannerUrl?: string | null;
  isVerified: boolean;
  createdAt: string; // ISO-8601 UTC
  updatedAt: string; // ISO-8601 UTC
}
