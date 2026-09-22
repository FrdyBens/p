import { HandoffState } from "../enums/HandoffState";
import { SourceProtocol } from "../enums/SourceProtocol";
import { PlaybackSession } from "../models/PlaybackSession";

export interface PlaybackSessionResponse {
  session: PlaybackSession;
}

export interface ResolvePlaybackSourceResponse {
  mediaId: string;
  sourceId: string;
  variantId?: string | null;
  playableUrl: string;
  headers: Record<string, string>;
  protocol: SourceProtocol;
  mimeType: string;
  durationMs: number;
  rangeSupport: boolean;
}

export interface HandoffResponse {
  handoffId: string;
  state: HandoffState;
  targetDeviceId: string;
  message?: string | null;
}
