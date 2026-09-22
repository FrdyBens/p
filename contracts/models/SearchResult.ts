import { SearchResultType } from "../enums/SearchResultType";

export interface SearchResult {
  entityId: string;
  resultType: SearchResultType;
  title: string;
  subtitle?: string | null;
  thumbnailUri?: string | null;
  score: number;
  badgeLabel?: string | null;
  metadata: Record<string, string>;
}
