import { Device } from "../models/Device";

export interface DeviceResponse {
  device: Device;
}

export interface DeviceListResponse {
  devices: Device[];
}

export interface PairDeviceResponse {
  deviceId: string;
  isPaired: boolean;
  pairingStatus: string;
  device?: Device | null;
}
