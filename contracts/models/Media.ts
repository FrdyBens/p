import { MediaKind } from "../enums/MediaKind";

export interface Media {
  id: string; // media_01j7b6k28xfw8a01
  title: string;
  overview?: string | null;
  mediaKind: MediaKind;
  durationMs: number;
  thumbnailUri: string;
  canonicalHash: string; // Content fingerprint
  channelId: string; // usr_...
  channelTitle: string;
  publishedAt: string; // ISO-8601 UTC
  viewsCount: number;
  pumpCount: number; // Likes
  punchCount: number; // Dislikes
  sourceCount: number;
  tags: string[];
  createdAt: string; // ISO-8601 UTC
  updatedAt: string; // ISO-8601 UTC
}
