# PULSY — AGENT ECOSYSTEM & MULTI-AGENT DEVELOPMENT ARCHITECTURE

> **Version:** 1.0.0  
> **Status:** RATIFIED  
> **Authority:** Foundation Architecture

---

## 1. Why a Multi-Agent Ecosystem?

Pulsy is designed to be built in parallel by multiple autonomous AI coding agents (Gemini Flash, AI Studio instances) and human developers. 

Because each AI session runs with bounded context and quota limits, attempting to have one agent build the entire ecosystem results in context drift, broken architectures, and duplicate implementations. 

By partitioning Pulsy into **strictly bounded scopes** governed by **canonical contracts**, independent agents can build their assigned page or service in parallel without colliding.

---

## 2. The Canonical Agent Registry

```text
                               +-------------------+
                               | FOUNDATION_AGENT  |
                               +-------------------+
                                         │
                    ┌────────────────────┴────────────────────┐
                    ▼                                         ▼
         +--------------------+                     +--------------------+
         |  CONTRACTS_AGENT   |                     | ANDROID_FRAME_AGENT|
         +--------------------+                     +--------------------+
                    │                                         │
        ┌───────────┼───────────┐                 ┌───────────┼───────────┐
        ▼           ▼           ▼                 ▼           ▼           ▼
  +-----------++----------++----------+     +-----------++----------++----------+
  | DATABASE  || BACKEND  || RUNTIME  |     |   HOME    ||  PULSES  || LIBRARY  |
  |   AGENT   ||  AGENT   ||  AGENT   |     |   AGENT   ||  AGENT   ||  AGENT   |
  +-----------++----------++----------+     +-----------++----------++----------+
        │           │           │                 │           │           │
        └───────────┼───────────┘                 +-----------++----------+
                    ▼                             |  PLAYER   ||  MUSIC   | ...
         +--------------------+                   |   AGENT   ||  AGENT   |
         | MEDIA_SERVER_AGENT |                   +-----------++----------+
         +--------------------+                               │
                    │                                         │
                    └────────────────────┬────────────────────┘
                                         ▼
                              +--------------------+
                              | INTEGRATION_AGENT  |
                              +--------------------+
```

### 2.1 Foundation & Governance
- **`FOUNDATION_AGENT`**: Governs core architecture, rules, visual audit, and system documentation.
- **`CONTRACTS_AGENT`**: Owns `contracts/` (models, requests, responses, events, enums, errors).
- **`ANDROID_FRAME_AGENT`**: Owns the Android application shell (`MainActivity`, global navigation host, top-level scaffold, and `ui/`).

### 2.2 Infrastructure & Services
- **`DATABASE_AGENT`**: Owns PostgreSQL schemas, tables, migrations, and seeds in `database/`.
- **`BACKEND_AGENT`**: Owns native control plane services in `services/`.
- **`RUNTIME_AGENT`**: Owns the client runtime bridge in `runtime/` (mediates between UI and n8n/native backend).
- **`MEDIA_SERVER_AGENT`**: Owns test media server specifications and deployment in `services/media/` and `docs/development/`.

### 2.3 Page / Surface Agents
- **`HOME_AGENT`**: Owns `pages/home/**` (Pad: category carousels, hero banners, recommended media).
- **`PULSES_AGENT`**: Owns `pages/pulses/**` (Pulses: 9:16 vertical video feed, gesture scroller, floating action stack).
- **`LIBRARY_AGENT`**: Owns `pages/library/**` (Pocket: downloads, watch history, offline management, packups).
- **`PLAYER_AGENT`**: Owns `pages/player/**` (Universal Player overlay, full controls, waveform scrubber, PiP).
- **`MUSIC_AGENT`**: Owns `pages/music/**` (Mini-App: audio playback, albums, queue, audio visualizers).
- **`PUBLISH_AGENT`**: Owns `pages/publish/**` (Media ingest, local directory scanner trigger, metadata editor).
- **`STUDIO_AGENT`**: Owns `pages/studio/**` (Mini-App: timeline, clipping, captioning, video effects).
- **`PERSONA_AGENT`**: Owns `pages/persona/**` (User profile, channel details, subscriber count, watch statistics).
- **`DEVICES_AGENT`**: Owns `pages/devices/**` (LAN discovery list, device pairing PIN challenge, handoff triggers).
- **`SERVERS_AGENT`**: Owns `pages/servers/**` (Personal NAS and community server management, endpoint health).
- **`SEARCH_AGENT`**: Owns `pages/search/**` (Global search bar, recent query pills, filter modal, search results).
- **`NOTIFICATIONS_AGENT`**: Owns `pages/notifications/**` (Subscription alerts, system messages, pairing requests).

### 2.4 Integration & Release
- **`INTEGRATION_AGENT`**: Inspects manifests, verifies contracts, detects merge conflicts, compiles the whole app, and validates end-to-end CUJs.

---

## 3. Strict Ownership Boundaries

For every agent:
1. **OWNS**: Files and directories that this agent has exclusive permission to create, edit, or delete.
2. **MAY READ**: Subsystems the agent can inspect for interfaces, types, or design tokens.
3. **MUST NOT MODIFY**: Files strictly owned by other agents or core infrastructure.

**Rule:** If a page agent requires a new model or common component, it **must not** modify `contracts/` or `ui/components/` directly. It documents the requirement in `API_REQUIREMENTS.md` or submits a proposal for the `CONTRACTS_AGENT` or `ANDROID_FRAME_AGENT`.

---

## 4. The 12-Step Agent Startup Protocol

Every agent beginning work must execute this sequence in order:

```text
[STEP 1]  Open Git repository (ensure clean working tree).
[STEP 2]  Read `docs/agents/MASTER_AGENT.md`.
[STEP 3]  Read assigned instruction file `docs/agents/<AGENT_NAME>.md`.
[STEP 4]  Read referenced foundation docs (PULSY_RULES, PULSY_ARCHITECTURE, etc.).
[STEP 5]  Inspect current repository files in owned path.
[STEP 6]  Confirm Owned Paths vs. Forbidden Paths.
[STEP 7]  Inspect existing `contracts/` for models needed; do NOT invent duplicates.
[STEP 8]  Inspect existing `ui/components/` and `ui/tokens/` for reusable elements.
[STEP 9]  Implement strictly the owned scope.
[STEP 10] Run local verification and `compile_applet`.
[STEP 11] Write machine-readable `PAGE_MANIFEST.json` and human-readable `PAGE_HANDOFF.md`.
[STEP 12] Update `CHANGELOG.md` with explicit change records.
```

---

## 5. Standard Handoff Artifacts

Every agent completion produces four standardized artifacts in its owned directory:

1. **`PAGE_MANIFEST.json` / `SERVICE_MANIFEST.json`**: Machine-readable JSON manifest recording all actions, contracts consumed, routes, and dependencies.
2. **`PAGE_HANDOFF.md` / `SERVICE_HANDOFF.md`**: Human-readable architectural report detailing what was built, what was tested, and notes for the Integration Agent.
3. **`API_REQUIREMENTS.md`**: Formal specification of runtime endpoints or service contracts needed by this surface.
4. **`TESTS.md`**: Record of executed unit, Robolectric, or preview tests, along with test coverage status.
