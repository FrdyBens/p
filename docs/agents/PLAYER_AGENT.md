# PLAYER_AGENT.md

## Mission
Build and maintain the universal Player surface in `pages/player/` and core playback integration (`core/playback`), providing the full-screen playback overlay, glowing waveform scrubber, playback controls (Pop, Puls, Plop, Pulse-Pass, Pulse-Prior, Pace), audio/subtitle track selectors, and Picture-in-Picture (Peephole).

## Why This Agent Exists
To provide ONE shared playback engine and UI overlay for the entire Pulsy application. Home, Shorts, Library, and Music all rely on this single authoritative player system rather than creating incompatible custom players.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_COMMUNICATION.md`
4. `docs/architecture/VISUAL_REFERENCE_AUDIT.md` (Screenshot 6)

## Owns
- `pages/player/**`
  - `pages/player/PlayerOverlay.kt`
  - `pages/player/PlayerViewModel.kt`
  - `pages/player/components/**`
  - `pages/player/PAGE_HANDOFF.md`
  - `pages/player/PAGE_MANIFEST.json`
  - `pages/player/CHANGELOG.md`
- `core/playback/**`

## May Modify
- `pages/player/**`
- `core/playback/**`

## Must Not Modify
- `pages/home/**`
- `pages/library/**`
- `services/playback/**` (Backend playback service is owned by BACKEND_AGENT)

## Dependencies
- AndroidX Media3 / ExoPlayer.
- Canonical `PlaybackSession`, `PlaybackState`, `Media`, `MediaVariant`.
- Design tokens from `ui/tokens/`.

## Canonical Contracts
- `PlaybackSession`, `Media`, `MediaSource`, `MediaVariant`.

## Action IDs
- `media.pop`, `media.puls`, `media.plop`, `media.seek`, `media.pass`, `media.prior`, `media.pulse_pass`, `media.pulse_prior`, `media.pace`, `media.puff_up`, `media.pacify`, `media.volume`, `media.peephole`.

## Events
- Emits: `playback.started`, `playback.paused`, `playback.position_changed`, `playback.completed`.

## Permissions
- `FOREGROUND_SERVICE` and `FOREGROUND_SERVICE_MEDIA_PLAYBACK` in manifest.

## UI Requirements
- High-contrast glowing scrubber thumb and buffered track indicator.
- Hero center Pop/Puls button with pulse animation.
- Quick 10s skip controls (`Pulse-Pass` and `Pulse-Prior`).
- Playback speed sheet (0.5x, 1.0x, 1.25x, 1.5x, 2.0x).
- Fullscreen rotation lock/unlock toggle.
- 48.dp touch targets on all overlay icons.
- Auto-hide controls after 3 seconds of inactivity.

## API Requirements
- `runtime.updatePlaybackPosition(sessionId: String, positionMs: Long)`
- `runtime.getStreamUrl(mediaId: String, variantId: String?): String`

## Runtime Requirements
- Media3 SessionService integration for background playback and notification controls.
- Handle audio focus loss (pause on incoming call).

## Simulation Requirements
- Stream from test media server (`test_video_1080p.mp4`).

## Testing Requirements
- ExoPlayer playback lifecycle tests and scrubber seek calculation unit tests.

## Handoff Requirements
- `PAGE_HANDOFF.md` and `PAGE_MANIFEST.json` in `pages/player/`.

## Manifest Requirements
- Valid schema adhering to `docs/development/manifest.schema.json`.

## Common Failure Modes
- Leaking player instances across activity recreation.
- Forgetting to post position updates to history, breaking the Golden Path resume capability.

## Definition of Done
Universal player initializes, streams video, supports seek/pause/rate adjustment, handles orientation changes, updates history, and compiles cleanly.
