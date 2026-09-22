export interface AudioTrack {
  id: string;
  label: string;
  language: string;
  codec: string;
  channels: number;
  isDefault: boolean;
}

export interface SubtitleTrack {
  id: string;
  label: string;
  language: string;
  format: string;
  isDefault: boolean;
  isForced: boolean;
  sourceUri?: string | null;
}

export interface VideoTrack {
  id: string;
  label: string;
  width: number;
  height: number;
  fps: number;
  codec: string;
  bitrateBps: number;
  isHdr: boolean;
}

export interface Chapter {
  id: string;
  title: string;
  startMs: number;
  endMs: number;
  thumbnailUri?: string | null;
}
