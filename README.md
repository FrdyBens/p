# Pulsy — Distributed Personal Media Ecosystem

> *"Nothing is ever still. If it is on screen, it has a pulse."*

Pulsy is an Android-first distributed personal media ecosystem combining the best principles of contemporary video discovery (YouTube, TikTok/Shorts), personal streaming & server playback (Plex, VLC, Jellyfin), audio playback (Spotify), LAN device discovery, cross-device playback handoff, creator studio tooling, and modular extensions/mini-apps.

---

## ⚡ The Pulsy Foundation

Pulsy is designed as a **multi-agent, contract-first ecosystem**. Rather than a monolithic codebase built in isolation, Pulsy is constructed by specialized, independent AI and human agents working under strict ownership boundaries, shared contracts, and a unified control plane.

### 🧭 Architecture Quick Reference

| Area | Canonical Document | Description |
| :--- | :--- | :--- |
| **System Rules** | [`docs/architecture/PULSY_RULES.md`](docs/architecture/PULSY_RULES.md) | Universal laws of the Pulsy codebase. Non-negotiable. |
| **System Architecture** | [`docs/architecture/PULSY_ARCHITECTURE.md`](docs/architecture/PULSY_ARCHITECTURE.md) | Single control plane, Media Identity vs Location, core subsystems. |
| **Communication** | [`docs/architecture/PULSY_COMMUNICATION.md`](docs/architecture/PULSY_COMMUNICATION.md) | Action IDs, event vocabulary, error structures, schemas. |
| **Contracts** | [`docs/architecture/PULSY_CONTRACTS.md`](docs/architecture/PULSY_CONTRACTS.md) | Contract-first repository models, requests, responses, enums. |
| **UI & Tokens** | [`docs/architecture/PULSY_UI_SYSTEM.md`](docs/architecture/PULSY_UI_SYSTEM.md) | Design tokens, typography, dark/light theme, components, P-personality. |
| **Visual Audit** | [`docs/architecture/VISUAL_REFERENCE_AUDIT.md`](docs/architecture/VISUAL_REFERENCE_AUDIT.md) | Analysis of existing UI prototypes, preserved strengths, token mappings. |
| **Security & Auth** | [`docs/architecture/PULSY_SECURITY.md`](docs/architecture/PULSY_SECURITY.md) | Zero-trust credentials, database isolation, permission capabilities. |
| **Agent System** | [`docs/architecture/PULSY_AGENT_SYSTEM.md`](docs/architecture/PULSY_AGENT_SYSTEM.md) | Agent lifecycle, dependency graph, startup/handoff protocols. |
| **Development** | [`docs/development/DEVELOPMENT_WORKFLOW.md`](docs/development/DEVELOPMENT_WORKFLOW.md) | Simulation vs production runtime, n8n bridge, test media server. |
| **Decisions (ADRs)** | [`docs/decisions/`](docs/decisions/) | Architecture Decision Records (ADR-001 through ADR-008). |
| **Agent Directives** | [`docs/agents/MASTER_AGENT.md`](docs/agents/MASTER_AGENT.md) | Master instructions for all autonomous agents. |

---

## 🏗️ Repository Layout

The repository preserves the canonical directory structure:

```text
├── #pulsy_structure/   # Reference copy of the canonical layout
├── api/                # API definitions and routes (v1)
├── apps/               # Multi-platform client applications (android, desktop, web)
│   └── android/        # Primary Android client app
├── contracts/          # Shared, versioned data contracts (models, requests, responses, events, errors, enums)
├── core/               # Platform-agnostic core logic (auth, playback, media, devices, servers, etc.)
├── database/           # PostgreSQL migrations, schemas, documentation, and seeds
├── docs/               # System documentation, ADRs, workflows, and agent specifications
│   ├── architecture/   # System-wide architectural definitions
│   ├── decisions/      # Architecture Decision Records (ADRs)
│   ├── development/    # Workflows, startup/handoff protocols, manifest schemas
│   ├── agents/         # Dedicated agent instructions (MASTER_AGENT + 20 specialized agents)
│   └── pages/          # Per-page design records, changelogs, and handoffs
├── extensions/         # System extensions (e.g. AI Captions, FFmpeg, Importers)
├── mini-apps/          # Self-contained embedded applications (Studio, Music, Podcasts)
├── pages/              # Android page surfaces (home, pulses, library, player, etc.)
├── runtime/            # Runtime gateway (production vs simulation)
├── services/           # Backend services (media, playback, device, server, discovery, search)
├── tests/              # Contract, integration, unit, and E2E test suites
└── ui/                 # Reusable UI system (tokens, components, theme, icons, navigation)
```

---

## 🎯 Golden Path: The Universal Media Lifecycle

The Pulsy architecture guarantees the following uninterrupted lifecycle:

```text
SIGN IN (Persona)
   ↓
OPEN PULSY PAD (Home Feed)
   ↓
ADD LOCAL MEDIA (Storage / USB / Folder)
   ↓
BACKGROUND SCAN & CONTENT HASH (SHA-256)
   ↓
LOGICAL MEDIA ID ISSUED (media_xxx decoupled from physical path)
   ↓
POCKET / LIBRARY (Media appears with metadata & thumbnail)
   ↓
POP / PLAY (Universal Playback Session initiated)
   ↓
PULS / SEEK (Position & watch state persisted to PostgreSQL/Redis)
   ↓
CLOSE APP & REOPEN LATER
   ↓
CONTINUE WATCHING (Resumes exactly at persisted timestamp)
   ↓
MOVE / RENAME FILE ON DISK
   ↓
AUTOMATIC RESCAN (Hash matches -> Logical Media ID preserved -> History intact)
   ↓
PAIR SECOND DEVICE (LAN / Remote PIN)
   ↓
SEAMLESS HANDOFF (Playback state & queue transferred to target device)
```

---

## 🤖 For AI & Engineering Agents

Before executing any changes:
1. Read [`docs/agents/MASTER_AGENT.md`](docs/agents/MASTER_AGENT.md).
2. Read your specific assigned agent file in `docs/agents/<YOUR_AGENT>.md`.
3. Verify your **Owned Paths** and **Forbidden Paths**.
4. Check existing `contracts/` before defining any new models or APIs.
5. Record your changes in your page handoff and machine-readable `PAGE_MANIFEST.json`.
