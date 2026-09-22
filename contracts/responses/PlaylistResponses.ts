import { Playlist } from "../models/Playlist";
import { PlaylistItem } from "../models/PlaylistItem";
import { PageInfo } from "./Pagination";

export interface PlaylistResponse {
  playlist: Playlist;
  items: PlaylistItem[];
}

export interface PlaylistListResponse {
  items: Playlist[];
  pageInfo: PageInfo;
}
