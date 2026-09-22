export interface PaginationRequest {
  cursor?: string | null;
  limit: number;
  direction?: "next" | "prev";
}
