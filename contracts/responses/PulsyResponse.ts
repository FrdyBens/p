import { PulsyError } from "../errors/PulsyError";

export interface PulsyResponse<T> {
  requestId: string;
  action: string;
  status: "OK" | "ERROR";
  data?: T | null;
  error?: PulsyError | null;
  timestamp: string; // ISO-8601 UTC
}
