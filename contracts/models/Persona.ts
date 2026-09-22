export interface Persona {
  userId: string;
  bio?: string | null;
  subscribersCount: number;
  subscriptionsCount: number;
  totalPumpsReceived: number;
  primaryServerId?: string | null;
  isLive: boolean;
  currentLiveMediaId?: string | null;
}
