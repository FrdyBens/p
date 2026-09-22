# PERSONA_AGENT.md

## Mission
Build and maintain the Persona (Profile) surface in `pages/persona/`, showcasing user profile information, creator metrics, subscriber counts, total pumps (likes) received, watch time statistics, linked devices, and account configuration.

## Why This Agent Exists
To provide a unified identity hub for both media consumers and creators, linking personal preferences, connected nodes, and channel statistics.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_UI_SYSTEM.md`
4. `docs/architecture/VISUAL_REFERENCE_AUDIT.md` (Screenshot 8)

## Owns
- `pages/persona/**`
  - `pages/persona/PersonaScreen.kt`
  - `pages/persona/PersonaViewModel.kt`
  - `pages/persona/components/**`
  - `pages/persona/PAGE_HANDOFF.md`
  - `pages/persona/PAGE_MANIFEST.json`
  - `pages/persona/CHANGELOG.md`

## May Modify
- `pages/persona/**`

## Must Not Modify
- `pages/home/**`
- `core/auth/**` (Auth logic is owned by Core/Backend)
- `database/**`

## Dependencies
- Canonical `User`, `Persona` models.
- Shared components from `ui/components/`.

## Canonical Contracts
- `User`, `Persona`, `Device`.

## Action IDs
- `persona.update_profile`, `persona.switch_account`, `persona.manage_subscriptions`.

## Events
- Consumes: `user.updated`.

## Permissions
- None.

## UI Requirements
- Banner image at top with rounded avatar overlay (glowing neon border).
- User display name, handle (`@handle`), and verified badge.
- Stats card row: Subscribers (Pair count), Likes (Pumps), Total Watch Hours.
- Tabs: "Uploads", "Playlists (Packups)", "Liked (Pumped)", "About".
- 48.dp minimum touch targets.

## API Requirements
- `runtime.getCurrentUser(): User`
- `runtime.getPersonaStats(): Persona`
- `runtime.updateProfile(req: UpdateProfileRequest): User`

## Runtime Requirements
- Fast cached profile loading with background refresh.

## Simulation Requirements
- Display test user persona (`@cyberpulsar`) with realistic sample stats.

## Testing Requirements
- Profile state rendering and tab switching unit tests.

## Handoff Requirements
- `PAGE_HANDOFF.md` and `PAGE_MANIFEST.json` in `pages/persona/`.

## Manifest Requirements
- Valid schema adhering to `docs/development/manifest.schema.json`.

## Common Failure Modes
- Exposing raw user auth tokens or database IDs in the UI.
- Missing error state if profile fails to load.

## Definition of Done
Persona screen displays user profile, banner, stats cards, tabbed media rows, edit options, and compiles cleanly.
