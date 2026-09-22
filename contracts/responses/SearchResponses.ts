import { SearchResult } from "../models/SearchResult";
import { PageInfo } from "./Pagination";

export interface SearchFacet {
  category: string;
  value: string;
  count: number;
}

export interface SearchResponse {
  query: string;
  results: SearchResult[];
  facets: SearchFacet[];
  pageInfo: PageInfo;
}
