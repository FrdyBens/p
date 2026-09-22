# Canonical Events (`contracts/events/`)

Asynchronous domain lifecycle events for state synchronization across Pulsy runtimes, background services, and reactive UI streams.

## Structure
- `PulsyEvent.kt` / `PulsyEvent.ts`: Universal event envelope with `eventId`, `eventType`, `eventVersion`, `actorId`, `subjectId`, `payload`, and `metadata`.
- `DomainEvents.kt` / `DomainEvents.ts`: Typed payload definitions for playback, media, devices, servers, playlists, history, and notifications.

## Rules
1. Events are immutable and strictly versioned (`eventVersion = "1.0.0"`).
2. Playback state updates broadcast via `playback.*` events so remote controlling devices remain synchronized.
3. Media discovery and file movements emit `media.source.discovered` and `media.source.lost` without altering logical `MediaId`.
