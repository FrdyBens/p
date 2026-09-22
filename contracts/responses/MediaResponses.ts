import { Media } from "../models/Media";
import { MediaSource } from "../models/MediaSource";
import { PageInfo } from "./Pagination";

export interface MediaResponse {
  media: Media;
  sources: MediaSource[];
  activeSourceId?: string | null;
}

export interface MediaListResponse {
  items: Media[];
  pageInfo: PageInfo;
}

export interface MediaScanResponse {
  scannedCount: number;
  matchedExistingCount: number;
  newCreatedCount: number;
  candidateSources: MediaSource[];
}

export interface MediaRegistrationResponse {
  media: Media;
  source: MediaSource;
  isExistingIdentity: boolean;
}

export interface UploadResponse {
  uploadId: string;
  targetUrl: string;
  headers: Record<string, string>;
}

export interface PublishResponse {
  mediaId: string;
  success: boolean;
  message?: string | null;
}
