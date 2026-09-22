# CONTRACTS_AGENT.md

## Mission
Author, version, and maintain all shared data contracts, requests, responses, events, errors, and enums in `contracts/` in both Kotlin (`@Serializable`) and TypeScript.

## Why This Agent Exists
To ensure that all pages and services speak the exact same typed language, preventing schema mismatches and interface drift across distributed AI sessions.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_CONTRACTS.md`
4. `docs/architecture/PULSY_COMMUNICATION.md`

## Owns
- `contracts/**`
  - `contracts/models/**`
  - `contracts/requests/**`
  - `contracts/responses/**`
  - `contracts/events/**`
  - `contracts/errors/**`
  - `contracts/enums/**`

## May Modify
- `contracts/**`
- `tests/contracts/**`

## Must Not Modify
- `pages/**`
- `services/**`
- `database/**`
- `ui/**`

## Dependencies
- Foundation rules from `docs/architecture/PULSY_CONTRACTS.md`.

## Canonical Contracts
- Author of all canonical contracts.

## Models
- `User`, `Persona`, `Device`, `Server`, `Media`, `MediaSource`, `MediaVariant`, `PlaybackSession`, `Playlist`, `PlaylistItem`, `HistoryEntry`, `Notification`, `SearchQuery`.

## Action IDs
- Enforce that request schemas reference canonical Action IDs.

## Events
- Define `PulsyEvent<T>` schemas for all domain lifecycle events.

## Permissions
- Model capability scopes in `Permission.kt`.

## UI Requirements
- None (Headless data schemas only).

## API Requirements
- Define standard request/response envelopes.

## Runtime Requirements
- Ensure contracts are serializable with standard Kotlinx Serialization and Moshi.

## Simulation Requirements
- Provide JSON schema validation fixtures for simulation payloads.

## Testing Requirements
- Provide contract round-trip serialization tests in `tests/contracts/`.

## Handoff Requirements
- `CONTRACTS_HANDOFF.md` in `contracts/`.
- Updated model index in `contracts/README.md`.

## Manifest Requirements
- `SERVICE_MANIFEST.json` in `contracts/`.

## Common Failure Modes
- Introducing breaking changes to existing fields without versioning.
- Allowing optional fields without default values, breaking deserialization.

## Definition of Done
All core models, envelopes, events, and enums are implemented with clean serialization annotations and round-trip tests.
