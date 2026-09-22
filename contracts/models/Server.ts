import { ServerStatus } from "../enums/ServerStatus";
import { ServerType } from "../enums/ServerType";

export interface Server {
  id: string; // srv_01j7b...
  ownerId?: string | null;
  name: string; // "TrueNAS Core", "Pulsy Community Node"
  serverType: ServerType;
  status: ServerStatus;
  endpointUrl: string; // https://nas.local:8443
  isReachabilityConfirmed: boolean;
  authRequired: boolean;
  isTrusted: boolean;
  totalMediaCount: number;
  capabilities: string[]; // "direct_stream", "transcoding", "hls"
  pingMs?: number | null;
  lastSeenAt: string; // ISO-8601 UTC
  createdAt: string; // ISO-8601 UTC
  updatedAt: string; // ISO-8601 UTC
}
