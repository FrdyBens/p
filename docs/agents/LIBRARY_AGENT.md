# LIBRARY_AGENT.md

## Mission
Build and maintain the Pocket (Library) surface in `pages/library/`, managing offline downloads, watch history carousels, custom Packups (playlists), watch later collections (Postpone), and local/server storage allocation indicators.

## Why This Agent Exists
To provide users with complete control over their personal collections, offline pocket storage, and playback history across all connected sources.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_UI_SYSTEM.md`
4. `docs/architecture/VISUAL_REFERENCE_AUDIT.md` (Screenshot 4)

## Owns
- `pages/library/**`
  - `pages/library/LibraryScreen.kt`
  - `pages/library/LibraryViewModel.kt`
  - `pages/library/components/**`
  - `pages/library/PAGE_HANDOFF.md`
  - `pages/library/PAGE_MANIFEST.json`
  - `pages/library/CHANGELOG.md`

## May Modify
- `pages/library/**`

## Must Not Modify
- `pages/home/**`
- `pages/player/**`
- `database/migrations/**` (Requests from DATABASE_AGENT)

## Dependencies
- Canonical models `Playlist`, `PlaylistItem`, `HistoryEntry`, `Media`.
- Shared components from `ui/components/`.

## Canonical Contracts
- `Playlist`, `HistoryEntry`, `Media`, `MediaSource`.

## Action IDs
- `storage.pocket`: Manage offline downloads.
- `playlist.packup.create`: Create a new playlist.
- `playlist.packup.remove`: Remove an item from playlist.
- `media.pop`: Play a playlist or history item.

## Events
- Consumes: `playlist.updated`, `playback.completed`.

## Permissions
- Android foreground service permission for background downloads.

## UI Requirements
- Top horizontal carousel for "Recently Watched" with duration badges and progress bars.
- Filter tabs: "All", "Packups (Playlists)", "Pocket (Downloads)", "Liked (Pumped)".
- Storage meter card showing local device storage vs connected NAS storage.
- 48.dp minimum touch targets on all list items and edit icons.

## API Requirements
- `runtime.getHistory(): List<HistoryEntry>`
- `runtime.getPlaylists(): List<Playlist>`
- `runtime.getDownloads(): List<MediaSource>`

## Runtime Requirements
- Seamless offline state: if network is unavailable, show locally pocketed media without error screens.

## Simulation Requirements
- Display mock storage metrics and offline playlist items in simulation mode.

## Testing Requirements
- Unit tests for playlist filtering and watch history resume point calculation.

## Handoff Requirements
- `PAGE_HANDOFF.md` and `PAGE_MANIFEST.json` in `pages/library/`.

## Manifest Requirements
- Valid schema adhering to `docs/development/manifest.schema.json`.

## Common Failure Modes
- Coupling downloads directly to raw hardcoded Android file paths rather than `MediaSource`.
- Missing empty states for new users with no history.

## Definition of Done
Library screen renders history, playlists, downloads, storage bar, handles clicks cleanly, and compiles.
