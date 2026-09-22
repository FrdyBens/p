import { MediaKind } from "../enums/MediaKind";
import { SearchResultType } from "../enums/SearchResultType";
import { SourceType } from "../enums/SourceType";
import { PaginationRequest } from "./Pagination";

export interface SearchFilters {
  entityTypes?: SearchResultType[];
  mediaKinds?: MediaKind[];
  sourceTypes?: SourceType[];
  minDurationMs?: number | null;
  maxDurationMs?: number | null;
  channelId?: string | null;
  tags?: string[];
  isOnlyBookmarked?: boolean;
}

export interface SearchSort {
  field?: "relevance" | "publishedAt" | "duration" | "views" | "pumpCount";
  direction?: "asc" | "desc";
}

export interface SearchRequest {
  query: string;
  filters?: SearchFilters | null;
  sort?: SearchSort | null;
  pagination?: PaginationRequest | null;
}
