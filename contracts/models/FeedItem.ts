import { Media } from "./Media";

export interface FeedItem {
  feedItemId: string; // fdi_01j7b...
  mediaId: string; // Reference to canonical Media
  media?: Media | null;
  rankScore: number;
  engagementPumps: number;
  engagementPatters: number;
  isPumpedByUser: boolean;
  recommendedReason?: string | null;
}
