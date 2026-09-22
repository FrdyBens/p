import { HandoffState } from "../enums/HandoffState";
import { PlaybackQueue } from "./PlaybackQueue";

export interface HandoffPayload {
  handoffId: string; // hnd_01j7b...
  sourceDeviceId: string;
  targetDeviceId: string;
  mediaId: string; // Canonical Media ID
  sourceId: string;
  variantId?: string | null;
  positionMs: number;
  durationMs: number;
  pace: number;
  volume: number;
  isMuted: boolean;
  audioTrackId?: string | null;
  subtitleTrackId?: string | null;
  state: HandoffState;
  queue?: PlaybackQueue | null;
  timestamp: string; // ISO-8601 UTC
}
