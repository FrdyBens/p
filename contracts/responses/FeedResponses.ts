import { FeedItem } from "../models/FeedItem";
import { PageInfo } from "./Pagination";

export interface FeedResponse {
  feedType: string;
  items: FeedItem[];
  pageInfo: PageInfo;
}
