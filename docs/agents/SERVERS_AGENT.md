# SERVERS_AGENT.md

## Mission
Build and maintain the Servers surface in `pages/servers/`, managing connections to personal media servers (TrueNAS, Unraid, home Jellyfin/Plex), remote servers, and authorized community servers.

## Why This Agent Exists
To empower users to anchor their self-hosted storage and personal media servers into the Pulsy control plane without exposing their entire ecosystem to remote hosts.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_SECURITY.md`
4. `docs/architecture/VISUAL_REFERENCE_AUDIT.md` (Screenshot 7)

## Owns
- `pages/servers/**`
  - `pages/servers/ServersScreen.kt`
  - `pages/servers/ServersViewModel.kt`
  - `pages/servers/components/**`
  - `pages/servers/PAGE_HANDOFF.md`
  - `pages/servers/PAGE_MANIFEST.json`
  - `pages/servers/CHANGELOG.md`

## May Modify
- `pages/servers/**`

## Must Not Modify
- `pages/devices/**`
- `services/server/**`
- `database/**`

## Dependencies
- Canonical `Server` model.
- Shared components from `ui/components/`.

## Canonical Contracts
- `Server`, `ServerType`.

## Action IDs
- `server.register`: Add new server endpoint URL.
- `server.ping`: Check latency and reachability.
- `server.sync`: Trigger library metadata rescan.
- `server.disconnect`: Disconnect server.

## Events
- Consumes: `server.connected`, `server.disconnected`.

## Permissions
- None.

## UI Requirements
- Server cards showing name, endpoint URL, status pulse (Green = Online, Amber = Latency High, Red = Offline).
- Library metrics (e.g. "1,420 Movies, 340 Albums").
- "Anchor Server" floating action button.
- Server configuration dialog (Endpoint, Auth Token / API Key, SSL toggle).
- 48.dp minimum touch targets.

## API Requirements
- `runtime.getRegisteredServers(): List<Server>`
- `runtime.pingServer(serverId: String): Long` (Latency in ms)
- `runtime.registerServer(req: ServerRegistrationRequest): Server`

## Runtime Requirements
- Validate HTTPS/TLS connection security before saving server endpoints.

## Simulation Requirements
- Display 2 simulated servers (Home TrueNAS Core, Community Media Relay).

## Testing Requirements
- URL validation and server latency parsing unit tests.

## Handoff Requirements
- `PAGE_HANDOFF.md` and `PAGE_MANIFEST.json` in `pages/servers/`.

## Manifest Requirements
- Valid schema adhering to `docs/development/manifest.schema.json`.

## Common Failure Modes
- Exposing remote servers to local device control without explicit capability checks.
- Blocking UI on slow server ping timeouts.

## Definition of Done
Servers screen lists connected personal and community servers, provides registration and health checks, and compiles cleanly.
