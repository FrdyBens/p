import { Server } from "../models/Server";

export interface ServerResponse {
  server: Server;
}

export interface ServerListResponse {
  servers: Server[];
}
