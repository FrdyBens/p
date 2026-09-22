export interface PageInfo {
  nextCursor?: string | null;
  prevCursor?: string | null;
  hasMore: boolean;
  totalCount?: number | null;
}

export interface PaginationResponse<T> {
  items: T[];
  pageInfo: PageInfo;
}
