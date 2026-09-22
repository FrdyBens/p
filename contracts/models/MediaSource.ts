import { SourceProtocol } from "../enums/SourceProtocol";
import { SourceType } from "../enums/SourceType";

export interface MediaSource {
  id: string; // src_01j7b...
  mediaId: string; // Logical Media reference
  deviceId?: string | null;
  serverId?: string | null;
  sourceType: SourceType;
  protocol: SourceProtocol;
  rawUri: string;
  isOnline: boolean;
  priority: number; // Lower number = higher priority
  canStream: boolean;
  canDownload: boolean;
  lastVerifiedAt: string; // ISO-8601 UTC
}
