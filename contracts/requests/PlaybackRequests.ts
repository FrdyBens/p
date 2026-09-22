import { RepeatMode } from "../enums/RepeatMode";
import { SourceProtocol } from "../enums/SourceProtocol";
import { PlaybackCapabilities } from "../models/PlaybackCapabilities";

export interface PlayMediaRequest {
  mediaId: string;
  preferredSourceId?: string | null;
  preferredVariantId?: string | null;
  startPositionMs?: number;
  targetDeviceId?: string | null;
  controllingDeviceId?: string | null;
}

export interface PauseMediaRequest {
  sessionId: string;
}

export interface StopMediaRequest {
  sessionId: string;
}

export interface SeekRequest {
  sessionId: string;
  positionMs: number;
}

export interface PaceRequest {
  sessionId: string;
  pace: number;
}

export interface VolumeRequest {
  sessionId: string;
  volume: number;
}

export interface PacifyRequest {
  sessionId: string;
  isMuted: boolean;
}

export interface PerpetualRequest {
  sessionId: string;
  repeatMode: RepeatMode;
}

export interface PotluckRequest {
  sessionId: string;
  isShuffled: boolean;
}

export interface SelectTrackRequest {
  sessionId: string;
  trackType: "AUDIO" | "SUBTITLE";
  trackId?: string | null;
}

export interface HandoffRequest {
  sourceDeviceId: string;
  targetDeviceId: string;
  sessionId: string;
  mediaId: string;
  positionMs: number;
}

export interface ResolvePlaybackSourceRequest {
  mediaId: string;
  preferredProtocol?: SourceProtocol | null;
  maxBitrateBps?: number | null;
  clientCapabilities?: PlaybackCapabilities | null;
}
