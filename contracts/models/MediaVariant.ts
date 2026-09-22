export interface MediaVariant {
  id: string; // var_01j7b...
  mediaId: string;
  sourceId: string;
  qualityLabel: string; // "1080p60", "4K HDR", "320kbps MP3"
  resolutionWidth?: number | null;
  resolutionHeight?: number | null;
  bitrateBps: number;
  videoCodec?: string | null;
  audioCodec?: string | null;
  containerFormat: string; // "mp4", "mkv", "webm", "m3u8"
  fps?: number | null;
  isHdr: boolean;
  sizeBytes?: number | null;
}
