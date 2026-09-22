export interface IdentityEvidence {
  contentHashSha256: string;
  perceptualHash?: string | null;
  quickHash?: string | null;
  fileSize: number;
  durationMs?: number | null;
  externalProviderId?: string | null;
  containerFormat?: string | null;
  matchConfidence: number; // 0.0 to 1.0
}
