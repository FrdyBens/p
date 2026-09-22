export enum MediaKind {
  VIDEO = "VIDEO",
  AUDIO = "AUDIO",
  SHORT_PULSE = "SHORT_PULSE",
  LIVE_STREAM = "LIVE_STREAM",
  PODCAST = "PODCAST",
}

export type MediaType = MediaKind;
export const MediaType = MediaKind;
