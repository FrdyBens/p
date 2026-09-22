# HOME_AGENT.md

## Mission
Build and maintain the Pad (Home) surface in `pages/home/`, presenting hero media highlights, horizontal category chips, recommended media feeds, live stream badges, and continue-watching carousels.

## Why This Agent Exists
To provide the primary discovery entry point of Pulsy without coupling feed logic to playback internals or backend implementation details.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_UI_SYSTEM.md`
4. `docs/architecture/VISUAL_REFERENCE_AUDIT.md` (Screenshots 1 & 2)

## Owns
- `pages/home/**`
  - `pages/home/HomeScreen.kt`
  - `pages/home/HomeViewModel.kt`
  - `pages/home/components/**`
  - `pages/home/PAGE_HANDOFF.md`
  - `pages/home/PAGE_MANIFEST.json`
  - `pages/home/CHANGELOG.md`

## May Modify
- `pages/home/**`

## Must Not Modify
- `pages/player/**` (Must call `media.pop` via runtime/action instead)
- `pages/pulses/**`
- `pages/library/**`
- `ui/components/**` (Requests additions from ANDROID_FRAME_AGENT)
- `database/**`

## Dependencies
- Shared components from `ui/components/` (`PulsyMediaCard`, `PulsyButton`, etc.).
- Canonical `Media` model from `contracts/models/Media.kt`.
- `PulsyRuntime` for querying recommended media.

## Canonical Contracts
- `Media`, `User`, `PlaybackSession`.

## Action IDs
- `media.pop`: Tapping a card to start playback.
- `social.pump`: Liking media from card menu.
- `playlist.postpone`: Adding to Watch Later.
- `social.pass_pulse`: Sharing media.

## Events
- Consumes: `playback.position_changed` (updates progress bar on continue-watching cards).

## Permissions
- None (Internet handled by shell).

## UI Requirements
- Dynamic hero banner at top with high-energy pulsing Play button.
- Horizontal scrollable category chips ("All", "Gaming", "Synthwave", "LAN Streams", "Podcasts").
- 16:9 media cards using `PulsyMediaCard`.
- 16.dp screen padding, 48.dp minimum touch targets.

## API Requirements
- `runtime.getHomeHighlights(): List<Media>`
- `runtime.getFeedCategories(): List<String>`
- `runtime.getContinueWatching(): List<HistoryEntry>`

## Runtime Requirements
- Clean loading shimmer skeleton while media items load.
- Pull-to-refresh support.

## Simulation Requirements
- Display test fixtures when running in simulation mode.

## Testing Requirements
- ViewModel state unit tests and Composable render tests.

## Handoff Requirements
- `PAGE_HANDOFF.md` and `PAGE_MANIFEST.json` in `pages/home/`.

## Manifest Requirements
- Valid schema adhering to `docs/development/manifest.schema.json`.

## Common Failure Modes
- Building an internal video player inside the feed instead of delegating to the Player subsystem.
- Hardcoding static sample data directly in Composable code.

## Definition of Done
Pad/Home screen renders responsive hero banner, category chips, media cards, handles item clicks via `media.pop`, and compiles cleanly.
