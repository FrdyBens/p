# DEVICES_AGENT.md

## Mission
Build and maintain the Devices surface in `pages/devices/`, listing discovered LAN hardware (phones, tablets, TVs, PCs), managing pairing PIN challenges, checking node health, and triggering cross-device playback handoffs (`Pass-Pulse`).

## Why This Agent Exists
To fulfill Pulsy's promise of effortless cross-device playback and LAN discovery while strictly enforcing the "Discovered != Trusted" security rule.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_SECURITY.md`
4. `docs/architecture/VISUAL_REFERENCE_AUDIT.md` (Screenshot 7)

## Owns
- `pages/devices/**`
  - `pages/devices/DevicesScreen.kt`
  - `pages/devices/DevicesViewModel.kt`
  - `pages/devices/components/**`
  - `pages/devices/PAGE_HANDOFF.md`
  - `pages/devices/PAGE_MANIFEST.json`
  - `pages/devices/CHANGELOG.md`

## May Modify
- `pages/devices/**`

## Must Not Modify
- `services/discovery/**` (Backend discovery daemon is owned by BACKEND_AGENT)
- `pages/player/**`
- `database/**`

## Dependencies
- Canonical `Device`, `PlaybackSession` models.
- Shared components from `ui/components/`.

## Canonical Contracts
- `Device`, `DeviceType`, `PlaybackSession`.

## Action IDs
- `device.discover`: Trigger active LAN scan.
- `device.pair`: Submit 6-digit PIN challenge.
- `device.handoff`: Transfer active `PlaybackSession` to target device.
- `device.unpair`: Remove trusted pairing token.

## Events
- Consumes: `device.discovered`, `device.paired`.

## Permissions
- `ACCESS_NETWORK_STATE` and `CHANGE_WIFI_MULTICAST_STATE` (for LAN discovery).

## UI Requirements
- Section 1: "Active Playback Node" (Current device playing media).
- Section 2: "Paired Devices" (Trusted living room TV, PC, tablet) with online/offline pulse indicator.
- Section 3: "Available Nodes on LAN" with "Pair (Enter PIN)" button.
- Clean PIN entry bottom sheet.
- 48.dp minimum touch targets.

## API Requirements
- `runtime.getDiscoveredDevices(): List<Device>`
- `runtime.pairDevice(deviceId: String, pin: String): Boolean`
- `runtime.handoffPlayback(targetDeviceId: String)`

## Runtime Requirements
- Zero UI freeze during background mDNS/SSDP network broadcast checks.

## Simulation Requirements
- Display 3 simulated LAN devices (Pixel 9, Shield TV, Mac Mini).

## Testing Requirements
- Pairing PIN input validation and handoff state machine unit tests.

## Handoff Requirements
- `PAGE_HANDOFF.md` and `PAGE_MANIFEST.json` in `pages/devices/`.

## Manifest Requirements
- Valid schema adhering to `docs/development/manifest.schema.json`.

## Common Failure Modes
- Automatically granting full access to unverified devices upon discovery.
- Dropping active playback state during cross-device transfer.

## Definition of Done
Devices screen displays local and network devices, handles pairing flow, triggers playback handoff, and compiles cleanly.
