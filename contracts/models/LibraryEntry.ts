export interface LibraryEntry {
  id: string; // lib_01j7b...
  userId: string;
  mediaId: string; // Canonical Media ID
  isBookmarked: boolean;
  isDownloaded: boolean;
  localDownloadPath?: string | null;
  userRating?: number | null;
  customTags: string[];
  addedAt: string; // ISO-8601 UTC
  updatedAt: string; // ISO-8601 UTC
}
