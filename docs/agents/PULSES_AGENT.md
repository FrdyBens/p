# PULSES_AGENT.md

## Mission
Build and maintain the Pulses surface in `pages/pulses/`, delivering an edge-to-edge 9:16 vertical video feed with vertical snap-paging, floating action rail (Pump, Punch, Patter, Pass-Pulse), creator badge, audio marquee, and gesture-driven playback controls.

## Why This Agent Exists
To provide a dedicated modern vertical short-form experience without creating an isolated playback backend or fragmenting the core media catalog.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_UI_SYSTEM.md`
4. `docs/architecture/VISUAL_REFERENCE_AUDIT.md` (Screenshot 3)

## Owns
- `pages/pulses/**`
  - `pages/pulses/PulsesScreen.kt`
  - `pages/pulses/PulsesViewModel.kt`
  - `pages/pulses/components/**`
  - `pages/pulses/PAGE_HANDOFF.md`
  - `pages/pulses/PAGE_MANIFEST.json`
  - `pages/pulses/CHANGELOG.md`

## May Modify
- `pages/pulses/**`

## Must Not Modify
- `pages/home/**`
- `pages/player/**`
- `core/playback/**`
- `database/**`

## Dependencies
- Canonical `Media` model (`mediaType == MediaType.SHORT_PULSE`).
- Shared ExoPlayer playback integration from `core/playback`.
- Design tokens from `ui/tokens/`.

## Canonical Contracts
- `Media`, `User`, `PlaybackState`.

## Action IDs
- `media.pop` / `media.puls`: Tap to pause/play.
- `social.pump`: Like pulse (animated heart/flame).
- `social.punch`: Dislike pulse.
- `social.patter`: Open comments bottom sheet.
- `social.pass_pulse`: Share pulse link.
- `social.pair`: Subscribe to creator.

## Events
- Emits: `playback.started`, `playback.paused` on vertical swipe.

## Permissions
- None.

## UI Requirements
- Edge-to-edge 9:16 aspect ratio display.
- Vertical `VerticalPager` with snap scrolling.
- Right-aligned floating action buttons with minimum 48.dp touch targets.
- Bottom gradient overlay scrim with creator avatar, handle, description, and spinning sound disk.

## API Requirements
- `runtime.getPulsesFeed(cursor: String?): List<Media>`
- `runtime.togglePump(mediaId: String): Boolean`

## Runtime Requirements
- Pre-buffering of next item in feed for instant playback transition.
- Release off-screen video decoders to conserve memory.

## Simulation Requirements
- Support playback of `test_short_pulse_9x16.mp4` from test media server.

## Testing Requirements
- Gesture scroll snap tests and action button callback tests.

## Handoff Requirements
- `PAGE_HANDOFF.md` and `PAGE_MANIFEST.json` in `pages/pulses/`.

## Manifest Requirements
- Valid schema adhering to `docs/development/manifest.schema.json`.

## Common Failure Modes
- Creating an independent database table for shorts instead of using canonical `Media`.
- Memory leaks from unreleased ExoPlayer instances during rapid swiping.

## Definition of Done
Pulses surface provides smooth vertical paging between short-form videos with functional floating action buttons, accessibility descriptions, and clean compilation.
