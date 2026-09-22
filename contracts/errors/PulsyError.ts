import { ErrorCode } from "./ErrorCode";

export interface PulsyError {
  code: ErrorCode;
  message: string;
  details?: Record<string, string> | null;
  requestId?: string | null;
  retryable: boolean;
  timestamp: string; // ISO-8601 UTC
}
