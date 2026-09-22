# STUDIO_AGENT.md

## Mission
Design and maintain the future Studio Mini-App in `pages/studio/` (`mini-apps/studio/`), establishing the boundary for creator editing, multi-track timelines, video trimming, caption generation, chapter marking, and short-form video repurposing.

## Why This Agent Exists
To provide a dedicated editing workspace for creators without cluttering the lightweight media consumption surfaces or allowing other agents to accidentally duplicate video editing tools.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_ARCHITECTURE.md` (Section 38: Future Studio)
3. `docs/architecture/PULSY_UI_SYSTEM.md`

## Owns
- `pages/studio/**`
  - `pages/studio/StudioScreen.kt`
  - `pages/studio/StudioViewModel.kt`
  - `pages/studio/components/**`
  - `pages/studio/PAGE_HANDOFF.md`
  - `pages/studio/PAGE_MANIFEST.json`
  - `pages/studio/CHANGELOG.md`
- `mini-apps/studio/**`

## May Modify
- `pages/studio/**`
- `mini-apps/studio/**`

## Must Not Modify
- `pages/home/**`
- `pages/player/**`
- `core/playback/**`

## Dependencies
- Canonical `Media`, `MediaVariant`.
- ExoPlayer preview surface.

## Canonical Contracts
- `Media`, `MediaVariant`.

## Action IDs
- `studio.project.create`, `studio.timeline.trim`, `studio.export`.

## Events
- Emits: `studio.export.completed`.

## Permissions
- `RECORD_AUDIO` if user initiates voiceover recording.

## UI Requirements
- Horizontal multi-track timeline (video track, audio track, subtitle/caption track).
- Playhead scrubber with frame-accurate preview.
- Trim handles with haptic snap feedback.
- Export resolution modal (1080p, 4K, 9:16 Pulse crop).
- 48.dp minimum touch targets.

## API Requirements
- `runtime.getStudioProjects()`
- `runtime.exportVideo(projectId: String)`

## Runtime Requirements
- Hardware-accelerated surface rendering (MediaCodec / OpenGL / Vulkan).

## Simulation Requirements
- Provide mock timeline project with sample video clips.

## Testing Requirements
- Keyframe and trim range calculation unit tests.

## Handoff Requirements
- `PAGE_HANDOFF.md` and `PAGE_MANIFEST.json` in `pages/studio/`.

## Manifest Requirements
- Valid schema adhering to `docs/development/manifest.schema.json`.

## Common Failure Modes
- Overbuilding heavy desktop video editing features that exceed mobile Android GPU limits.
- Blocking UI thread during video rendering.

## Definition of Done
Studio screen loads timeline UI, displays trim handles, previews clips, provides export options, and compiles cleanly.
