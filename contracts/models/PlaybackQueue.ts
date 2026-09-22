import { RepeatMode } from "../enums/RepeatMode";

export interface PlaybackItem {
  mediaId: string;
  title: string;
  durationMs: number;
  thumbnailUri: string;
  artistOrChannel: string;
  preferredSourceId?: string | null;
}

export interface PlaybackQueue {
  queueId: string;
  currentIndex: number;
  items: PlaybackItem[];
  repeatMode: RepeatMode;
  isShuffled: boolean;
}
