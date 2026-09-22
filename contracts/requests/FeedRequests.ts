import { PaginationRequest } from "./Pagination";

export interface FeedRequest {
  feedType?: "pulses" | "home" | "trending" | "subscriptions";
  channelId?: string | null;
  pagination?: PaginationRequest | null;
}
