# ANDROID_FRAME_AGENT.md

## Mission
Build and maintain the core Android application shell, including `MainActivity`, top-level `Scaffold`, global `NavHost`, edge-to-edge window insets, the floating pill bottom navigation bar, and shared design tokens and atomic components in `ui/`.

## Why This Agent Exists
To provide the common frame, navigation container, and reusable UI components that all page agents plug into, ensuring consistent padding, typography, dark theme, and navigation without page-level duplication.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_UI_SYSTEM.md`
4. `docs/architecture/VISUAL_REFERENCE_AUDIT.md`

## Owns
- `ui/**`
  - `ui/theme/**`
  - `ui/tokens/**`
  - `ui/components/**`
  - `ui/icons/**`
  - `ui/navigation/**`
- `apps/android/src/main/java/com/example/MainActivity.kt` (and top-level shell)

## May Modify
- Android manifest application tag
- Top-level Android resources (`strings.xml`, `colors.xml`)

## Must Not Modify
- `pages/**` (Except mounting page entry points into NavHost)
- `services/**`
- `database/**`

## Dependencies
- Jetpack Compose, Material 3, Navigation Compose.

## Canonical Contracts
- Navigation destination route constants.

## Models
- `Media`, `Device`, `PlaybackSession` (for mini-player integration).

## Action IDs
- Navigation actions: `nav.to_pad`, `nav.to_pulses`, `nav.to_publish`, `nav.to_pocket`, `nav.to_persona`.

## Events
- Listen to `playback.started` to show persistent bottom mini-player.

## Permissions
- Declare base permissions in `AndroidManifest.xml`.

## UI Requirements
- Enforce OLED dark theme (`#0B0D13` canvas), electric violet/cyan accents, 8.dp grid spacing, and 48.dp minimum touch targets.
- Implement floating pill bottom navigation bar with blur effect.

## API Requirements
- Consumes `PulsyRuntime` for global state (e.g. active playback).

## Runtime Requirements
- Full edge-to-edge support (`enableEdgeToEdge()`, `WindowInsets.systemBars`).

## Simulation Requirements
- Provide preview providers for all shared components.

## Testing Requirements
- Roborazzi screenshot tests for shared components.

## Handoff Requirements
- `FRAME_HANDOFF.md` in `ui/`.

## Manifest Requirements
- `FRAME_MANIFEST.json` in `ui/`.

## Common Failure Modes
- Hardcoding screen dimensions instead of responsive WindowSizeClasses.
- Missing `contentDescription` on navigation icons.

## Definition of Done
The Android application shell runs, displays the floating bottom bar with active pulse indicator, mounts placeholder pages, and all shared UI tokens and components are documented.
