# SEARCH_AGENT.md

## Mission
Build and maintain the Search surface in `pages/search/`, delivering instant query autocomplete, recent search pills, multi-source filters (Local, LAN Server, Community), media type toggles (Video, Audio, Shorts), and rich search result grids.

## Why This Agent Exists
To provide a unified discovery lens across the entire distributed personal media catalog, eliminating the need to browse individual folders or servers manually.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_UI_SYSTEM.md`
4. `docs/architecture/VISUAL_REFERENCE_AUDIT.md` (Screenshot 2)

## Owns
- `pages/search/**`
  - `pages/search/SearchScreen.kt`
  - `pages/search/SearchViewModel.kt`
  - `pages/search/components/**`
  - `pages/search/PAGE_HANDOFF.md`
  - `pages/search/PAGE_MANIFEST.json`
  - `pages/search/CHANGELOG.md`

## May Modify
- `pages/search/**`

## Must Not Modify
- `pages/home/**`
- `services/search/**` (Backend search engine is owned by BACKEND_AGENT)
- `database/**`

## Dependencies
- Canonical `SearchQuery`, `Media` models.
- Shared components from `ui/components/` (`PulsyMediaCard`).

## Canonical Contracts
- `SearchQuery`, `Media`, `MediaType`.

## Action IDs
- `search.submit`: Execute search query.
- `search.clear`: Clear query text and history.
- `media.pop`: Play search result item.

## Events
- None.

## Permissions
- None.

## UI Requirements
- Top search bar with leading search icon, clear button, and focused accent glow.
- Recent search chips with individual delete icons.
- Filter pills: "All", "Videos", "Music", "Pulses", "Local Only", "Servers".
- Empty search state with helpful suggestions.
- 48.dp minimum touch targets.

## API Requirements
- `runtime.search(query: String, filter: SearchFilter): List<Media>`
- `runtime.getRecentQueries(): List<String>`
- `runtime.clearRecentQueries()`

## Runtime Requirements
- Debounce query text input (300ms) to avoid excessive backend requests.

## Simulation Requirements
- Filter local test media catalog by query string in simulation mode.

## Testing Requirements
- Query debounce timing tests and filter predicate unit tests.

## Handoff Requirements
- `PAGE_HANDOFF.md` and `PAGE_MANIFEST.json` in `pages/search/`.

## Manifest Requirements
- Valid schema adhering to `docs/development/manifest.schema.json`.

## Common Failure Modes
- Initiating network requests on every keystroke without debouncing.
- Failing to handle empty or zero-result search queries gracefully.

## Definition of Done
Search screen provides interactive query input, recent pills, debounced search execution, result rendering, and compiles cleanly.
