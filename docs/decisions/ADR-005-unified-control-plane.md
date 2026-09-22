# ADR-005: Single Unified Control Plane Architecture

## Status
Accepted

## Context
When multi-agent teams develop complex apps with diverse surfaces (Home Feed, Shorts, Library, Music, Player, Studio), there is a dangerous tendency for each team/agent to invent its own independent backend (e.g. "Feed Backend", "Shorts Backend", "Player Server"). This leads to severe architectural fragmentation, inconsistent data models, and impossible cross-surface handoffs.

## Decision
Pulsy enforces **ONE single unified control plane**:
1. All client surfaces (Pad/Home, Pulses/Shorts, Pocket/Library, Player, Music, Studio) are consumers of a unified set of core services: `Auth`, `Media`, `Devices`, `Servers`, `Discovery`, `Permissions`, `Playback`, `Playlists`, `History`, and `Search`.
2. Playback is a centralized subsystem (`core/playback` / `services/playback`). No page may instantiate an isolated, private player engine.
3. Media models are universal: a short video in Pulses is a `Media` entity with `mediaType = SHORT_PULSE`, just as a movie is a `Media` entity with `mediaType = VIDEO`.

## Consequences
- **Positive:** Guarantees universal cross-surface consistency; a video watched in Pulses immediately reflects in Library history and can be added to any playlist.
- **Positive:** Eliminates redundant backend code.
- **Negative:** Requires disciplined coordination through shared contracts.
