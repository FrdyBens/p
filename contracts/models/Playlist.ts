export interface Playlist {
  id: string; // pack_01j7b...
  ownerId: string;
  title: string;
  description?: string | null;
  isPrivate: boolean;
  itemCount: number;
  coverArtUri?: string | null;
  createdAt: string; // ISO-8601 UTC
  updatedAt: string; // ISO-8601 UTC
}

export interface PlaylistItem {
  id: string; // itm_01j7b...
  playlistId: string;
  mediaId: string; // Canonical Media ID
  positionOrder: number;
  addedAt: string; // ISO-8601 UTC
}
