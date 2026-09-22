# MUSIC_AGENT.md

## Mission
Build and maintain the Music Mini-App in `pages/music/`, dedicated to high-fidelity audio playback, albums, artist views, queue management, visualizers, lyrics, and audio-only playlists.

## Why This Agent Exists
To provide a specialized audio experience optimized for music and podcast listening without duplicating the underlying media and playback engine.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_UI_SYSTEM.md`

## Owns
- `pages/music/**`
  - `pages/music/MusicScreen.kt`
  - `pages/music/MusicViewModel.kt`
  - `pages/music/components/**`
  - `pages/music/PAGE_HANDOFF.md`
  - `pages/music/PAGE_MANIFEST.json`
  - `pages/music/CHANGELOG.md`

## May Modify
- `pages/music/**`

## Must Not Modify
- `pages/player/**` (Consumes playback service instead)
- `pages/home/**`
- `core/playback/**`

## Dependencies
- Canonical `Media` (`mediaType == MediaType.AUDIO`).
- Universal playback engine (`PLAYER_AGENT`).
- Design tokens from `ui/tokens/`.

## Canonical Contracts
- `Media`, `Playlist`, `PlaybackSession`.

## Action IDs
- `media.pop`, `media.puls`, `media.pass`, `media.prior`, `media.perpetual` (Repeat), `media.potluck` (Shuffle).

## Events
- Consumes: `playback.position_changed`.

## Permissions
- None.

## UI Requirements
- Full-bleed square album artwork display with vibrant ambient backdrop color glow.
- Track title, artist name, and album name with high contrast.
- Queue management drawer showing upcoming tracks.
- Dynamic sine-wave or frequency bar audio visualizer reacting to playback.
- 48.dp minimum touch targets.

## API Requirements
- `runtime.getMusicCatalog(): List<Media>`
- `runtime.getAlbums(): List<Playlist>`

## Runtime Requirements
- Seamless gapless audio playback transition.

## Simulation Requirements
- Play `test_audio_stream.m4a` from test media server.

## Testing Requirements
- Queue reordering logic tests and repeat/shuffle state tests.

## Handoff Requirements
- `PAGE_HANDOFF.md` and `PAGE_MANIFEST.json` in `pages/music/`.

## Manifest Requirements
- Valid schema adhering to `docs/development/manifest.schema.json`.

## Common Failure Modes
- Creating a separate audio engine instead of delegating to Media3/Universal Player.
- Missing background playback notifications.

## Definition of Done
Music screen provides album browsing, queue management, audio playback controls, animated visualizer, and compiles cleanly.
