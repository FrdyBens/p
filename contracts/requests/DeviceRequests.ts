export interface DiscoverDevicesRequest {
  timeoutMs?: number;
  includeOffline?: boolean;
}

export interface PairDeviceRequest {
  deviceId: string;
  pairingCode?: string | null;
}

export interface UnpairDeviceRequest {
  deviceId: string;
}

export interface ConnectDeviceRequest {
  deviceId: string;
}
