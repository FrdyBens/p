import { PlaybackState } from "../enums/PlaybackState";
import { RepeatMode } from "../enums/RepeatMode";

export interface PlaybackSession {
  sessionId: string; // ses_01j7b...
  mediaId: string; // Logical Media ID
  activeSourceId: string; // MediaSource ID
  activeVariantId?: string | null;
  targetDeviceId: string;
  controllingDeviceId: string;
  state: PlaybackState;
  positionMs: number;
  durationMs: number;
  volume: number; // 0.0 to 1.0
  pace: number; // Speed (0.25 to 3.0)
  isMuted: boolean;
  isFullscreen: boolean;
  repeatMode: RepeatMode;
  isShuffled: boolean;
  selectedAudioTrackId?: string | null;
  selectedSubtitleTrackId?: string | null;
  updatedAt: string; // ISO-8601 UTC
}
