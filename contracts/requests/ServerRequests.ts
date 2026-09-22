export interface DiscoverServersRequest {
  scanLocalNetwork?: boolean;
  timeoutMs?: number;
}

export interface ConnectServerRequest {
  serverId: string;
  endpointUrl?: string | null;
  authToken?: string | null;
}

export interface DisconnectServerRequest {
  serverId: string;
}

export interface ScanServerRequest {
  serverId: string;
  targetDirectory?: string | null;
}
