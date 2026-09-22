import { MediaKind } from "../enums/MediaKind";
import { SourceProtocol } from "../enums/SourceProtocol";
import { SourceType } from "../enums/SourceType";
import { IdentityEvidence } from "../models/IdentityEvidence";

export interface GetMediaRequest {
  mediaId: string;
}

export interface MediaScanRequest {
  path: string;
  deviceId?: string | null;
  serverId?: string | null;
  recursive?: boolean;
}

export interface MediaRegistrationRequest {
  mediaId?: string | null;
  title: string;
  overview?: string | null;
  mediaKind: MediaKind;
  durationMs: number;
  thumbnailUri: string;
  rawUri: string;
  protocol: SourceProtocol;
  sourceType: SourceType;
  evidence: IdentityEvidence;
  deviceId?: string | null;
  serverId?: string | null;
  tags?: string[];
}

export interface UploadRequest {
  mediaId?: string | null;
  fileName: string;
  fileSize: number;
  mimeType: string;
  sha256Checksum: string;
}

export interface PublishRequest {
  mediaId: string;
  title: string;
  overview?: string | null;
  mediaKind: MediaKind;
  tags?: string[];
  isPublic?: boolean;
}
