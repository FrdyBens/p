export interface PlaybackCapabilities {
  supportedCodecs: string[];
  supportedContainers: string[];
  maxResolutionWidth: number;
  maxResolutionHeight: number;
  supportsHdr: boolean;
  supportsByteRange: boolean;
  supportsAudioPassthrough: boolean;
  maxAudioChannels: number;
}
