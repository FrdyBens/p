export interface CreatePlaylistRequest {
  title: string;
  description?: string | null;
  isPrivate?: boolean;
  initialMediaIds?: string[];
}

export interface UpdatePlaylistRequest {
  playlistId: string;
  title?: string | null;
  description?: string | null;
  isPrivate?: boolean | null;
  coverArtUri?: string | null;
}

export interface DeletePlaylistRequest {
  playlistId: string;
}

export interface AddPlaylistItemRequest {
  playlistId: string;
  mediaId: string; // Canonical Media ID
  targetPositionOrder?: number | null;
}

export interface RemovePlaylistItemRequest {
  playlistId: string;
  itemId: string;
}

export interface ReorderPlaylistRequest {
  playlistId: string;
  orderedItemIds: string[];
}
