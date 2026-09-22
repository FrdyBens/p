# PUBLISH_AGENT.md

## Mission
Build and maintain the Publish surface in `pages/publish/`, enabling users to import local media, initiate directory scans, select files via Android Photo Picker, edit title/tags/overview, and register new media into a library or server.

## Why This Agent Exists
To handle the ingestion gateway for personal and creator media into the Pulsy ecosystem while strictly enforcing the Media Identity vs Location separation.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_SECURITY.md`
4. `docs/architecture/VISUAL_REFERENCE_AUDIT.md` (Screenshot 9)

## Owns
- `pages/publish/**`
  - `pages/publish/PublishScreen.kt`
  - `pages/publish/PublishViewModel.kt`
  - `pages/publish/components/**`
  - `pages/publish/PAGE_HANDOFF.md`
  - `pages/publish/PAGE_MANIFEST.json`
  - `pages/publish/CHANGELOG.md`

## May Modify
- `pages/publish/**`

## Must Not Modify
- `pages/home/**`
- `services/media/**` (Requests backend ingest endpoints)
- `database/**`

## Dependencies
- Android Photo Picker (`ActivityResultContracts.PickVisualMedia`).
- Canonical `Media`, `MediaSource`.
- Design tokens from `ui/tokens/`.

## Canonical Contracts
- `Media`, `MediaSource`, `MediaType`.

## Action IDs
- `media.scan`: Scan a selected directory or OTG storage.
- `media.publish`: Finalize metadata and register media.

## Events
- Emits: `media.created`, `media.source.added`.

## Permissions
- Android Photo Picker (zero-permission storage access). Never request broad `READ_EXTERNAL_STORAGE`.

## UI Requirements
- Media picker card with animated upload/plus icon.
- Form fields: Title, Overview, Media Type (Video, Audio, Short Pulse), Category tags.
- Target library destination selector (Local Pocket, Personal NAS).
- Ingestion progress bar with SHA-256 fingerprinting indicator.
- 48.dp minimum touch targets.

## API Requirements
- `runtime.computeMediaFingerprint(uri: String): String`
- `runtime.publishMedia(metadata: MediaPublishRequest): Media`

## Runtime Requirements
- Background hashing worker that does not block the UI thread during large file SHA-256 computation.

## Simulation Requirements
- Mock file picker and instant fingerprint simulation.

## Testing Requirements
- Form validation tests (empty title error, valid tag parsing).

## Handoff Requirements
- `PAGE_HANDOFF.md` and `PAGE_MANIFEST.json` in `pages/publish/`.

## Manifest Requirements
- Valid schema adhering to `docs/development/manifest.schema.json`.

## Common Failure Modes
- Requesting obsolete Android storage permissions instead of the zero-permission Photo Picker.
- Assigning the raw filesystem path as the `MediaId`.

## Definition of Done
Publish screen allows file selection, metadata editing, displays fingerprint progress, triggers registration, and compiles cleanly.
