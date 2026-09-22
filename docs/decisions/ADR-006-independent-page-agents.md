# ADR-006: Independent Page Agents and Bounded Ownership

## Status
Accepted

## Context
Later AI coding agents (running on Google AI Studio / Gemini Flash) operate within bounded context windows and quota limitations. If multiple agents attempt to edit the same shared UI files or full application simultaneously, merge collisions, race conditions, and accidental overwrites make autonomous development impossible.

## Decision
Pulsy enforces **Strict Bounded Surface Ownership**:
1. Each major application surface is owned by exactly one specialized agent (e.g. `HOME_AGENT` owns `pages/home/**`, `PLAYER_AGENT` owns `pages/player/**`, etc.).
2. An agent is strictly forbidden from modifying files in directories owned by other agents.
3. If an agent requires cross-surface behavior (e.g. Home page triggering Player playback), it must call standard Action IDs (`media.pop`) or consume shared contracts (`contracts/models/Media.kt`), rather than copying code from another page.
4. Each agent must be able to run and compile independently, relying on contracts and standard runtime mocks where dependencies are pending.

## Consequences
- **Positive:** Enables parallel execution of dozens of AI Studio sessions without merge conflicts.
- **Positive:** Prevents duplicated implementations like `HomePlayer`, `ShortsPlayer`, and `LibraryPlayer`.
- **Negative:** Requires strict adherence to ownership boundaries.
