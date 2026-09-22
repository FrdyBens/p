import { DeviceStatus } from "../enums/DeviceStatus";
import { DeviceType } from "../enums/DeviceType";

export interface Device {
  id: string; // dev_01j7b...
  userId?: string | null;
  name: string; // "Pixel 9 Pro", "Living Room TV"
  deviceType: DeviceType;
  status: DeviceStatus;
  ipAddress: string;
  port: number;
  isOnline: boolean;
  isTrusted: boolean; // Paired and authorized
  capabilities: string[]; // "stream_sink", "remote_control", "4k_hdr"
  appVersion?: string | null;
  lastSeenAt: string; // ISO-8601 UTC
  createdAt: string; // ISO-8601 UTC
  updatedAt: string; // ISO-8601 UTC
}
