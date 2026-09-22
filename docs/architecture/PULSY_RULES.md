# PULSY RULES — THE CANONICAL CONSTITUTION

> **Version:** 1.0.0  
> **Status:** RATIFIED & BINDING  
> **Authority:** Pulsy Foundation Architecture  
> **Applies to:** All AI Agents, Human Developers, Subsystems, Pages, and Services.

---

## 1. The Prime Directives

### 1.1 Git is the Single Source of Truth
- The Git repository (`https://github.com/FrdyBens/p`) is the canonical source of truth.
- No parallel architecture, phantom repository, or shadow folder structures are permitted.
- Never recreate, move, or rename existing canonical root directories (`contracts`, `core`, `database`, `docs`, `pages`, `runtime`, `services`, `ui`, `apps`, `tests`).

### 1.2 Media Identity != Media Location (The Cardinal Law)
- A logical `MediaId` (`media_...`) represents the media entity itself, **NEVER** a physical filesystem path, URL, or device mount.
- Moving, renaming, or transferring a file between devices (PC, Phone, NAS, Server) **MUST NOT** destroy history, bookmarks, watch progress, playlists, or likes.
- Re-scanning a moved file with matching identity evidence (e.g. SHA-256 hash or verified fingerprint) resolves to the **same** logical `MediaId`.

### 1.3 One Unified Control Plane
- Pulsy has **ONE** unified control plane. There is no independent "Feed backend", "Shorts backend", "Player backend", or "Library backend".
- Surfaces are clients of common core services: Auth, Identity, Media, Devices, Servers, Discovery, Permissions, Playback, Playlists, History, and Search.

### 1.4 Strict UI Isolation: Zero Direct Database Access
- **No UI component or page Composable may ever connect directly to PostgreSQL or Redis.**
- UI never executes raw SQL, never calls Redis commands, and never holds database credentials.
- All client communications pass strictly through the **Pulsy Runtime / Service Interface** via typed API contracts.

### 1.5 Contract-First Development
- Canonical contracts reside under `contracts/`.
- No agent may invent local variations of global models (`HomeMedia`, `ShortsMedia`, `LibraryMedia` are strictly forbidden; there is only `Media`).
- Before an implementation depends on a cross-subsystem concept, its contract must be committed in `contracts/`.

### 1.6 Universal Action IDs
- Every interactive element or user action maps to a canonical, dot-notated `ActionId` (e.g., `media.pop`, `media.puls`, `media.seek`, `playlist.packup`).
- No page may invent ad-hoc strings for standard actions.

### 1.7 Zero Unsolicited Features & Scope Discipline
- Build strictly what is in your assigned agent scope. Never build unrequested navigation sidebars, random external API integrations, or unsolicited playground panels.

---

## 2. Infrastructure & Data Roles

### 2.1 PostgreSQL Role (Durable Source of Truth)
- **Engine:** PostgreSQL 16.x (`pulsy_dev`).
- **Data Held:** Durable business entities: users, identities, devices, registered servers, logical media, media sources, playlists, watch history, ACLs/permissions, metadata, and subscriptions.
- **Rules:** No fake JSON files acting as databases in production. Schema changes must occur via versioned SQL migrations in `database/migrations/`.

### 2.2 Redis Role (Fast / Ephemeral State)
- **Engine:** Redis 7.x.
- **Data Held:** Ephemeral state: real-time presence, locks, active playback coordination, transient pairing codes, rate limiting, and short-lived caching.
- **Rules:** Redis is not durable storage. Canonical records must always be backed by PostgreSQL.

### 2.3 n8n Development Bridge
- **Role:** Developer testing bridge only.
- **Rules:** UI never hardcodes n8n endpoints or payloads. The client interacts with the abstract `PulsyRuntime`. In development, `PulsyRuntime` delegates to n8n; in production, it communicates with the native backend.
- **Security:** Credentials and webhook tokens are injected via environment variables/secrets. Never commit secrets to Git.

### 2.4 Test Media Server Requirement
- Real media playback is required for development testing (ExoPlayer/Media3 streaming, byte-range seeking, HLS/DASH, buffering).
- Do not build playback around dead mock URLs or fake timers.

---

## 3. Brand & Personality Layer Rules

Pulsy uses a dynamic "P" personality vocabulary inspired by the principle:  
*"Nothing is ever still. If it is on screen, it has a pulse."*

### 3.1 Personality Vocabulary Mapping

| Concept | Personality Name | Action ID / Semantics | Accessibility Rule |
| :--- | :--- | :--- | :--- |
| **Play** | Pop | `media.pop` | Accessibility label must remain *"Play"* |
| **Pause** | Puls | `media.puls` | Accessibility label must remain *"Pause"* |
| **Stop** | Plop | `media.plop` | Accessibility label must remain *"Stop"* |
| **Next** | Pass | `media.pass` | Accessibility label must remain *"Next Track"* |
| **Previous** | Prior | `media.prior` | Accessibility label must remain *"Previous Track"* |
| **Fast-Forward** | Pulse-Pass | `media.pulse_pass` | Accessibility label must remain *"Fast Forward"* |
| **Rewind** | Pulse-Prior | `media.pulse_prior` | Accessibility label must remain *"Rewind"* |
| **Speed** | Pace | `media.pace` | Accessibility label must remain *"Playback Speed"* |
| **Fullscreen** | Puff-Up | `media.puff_up` | Accessibility label must remain *"Toggle Fullscreen"* |
| **Mute** | Pacify | `media.pacify` | Accessibility label must remain *"Mute Audio"* |
| **Volume** | Pumping-Slider | `media.volume` | Accessibility label must remain *"Volume Control"* |
| **Repeat** | Perpetual | `media.perpetual` | Accessibility label must remain *"Repeat"* |
| **Shuffle** | Potluck | `media.potluck` | Accessibility label must remain *"Shuffle"* |
| **Like** | Pump | `social.pump` | Accessibility label must remain *"Like"* |
| **Dislike** | Punch | `social.punch` | Accessibility label must remain *"Dislike"* |
| **Boost** | Propel | `social.propel` | Accessibility label must remain *"Boost Creator"* |
| **Subscribe** | Pair | `social.pair` | Accessibility label must remain *"Subscribe"* |
| **Unsubscribe**| Part | `social.part` | Accessibility label must remain *"Unsubscribe"* |
| **Playlist** | Packup | `playlist.packup` | Accessibility label must remain *"Playlist"* |
| **Download** | Pocket | `storage.pocket` | Accessibility label must remain *"Download for Offline"* |
| **Share** | Pass-Pulse | `social.pass_pulse` | Accessibility label must remain *"Share"* |
| **Comments** | Patter | `social.patter` | Accessibility label must remain *"Comments"* |
| **Live Chat** | Prattle | `social.prattle` | Accessibility label must remain *"Live Chat"* |
| **Pinned** | Pinned-Patter | `social.pinned_patter`| Accessibility label must remain *"Pinned Comment"* |
| **Tips** | Pennies | `monetization.pennies`| Accessibility label must remain *"Tip Creator"* |
| **Report** | Penalize | `moderation.penalize` | Accessibility label must remain *"Report Content"* |
| **Watch Later**| Postpone | `playlist.postpone` | Accessibility label must remain *"Watch Later"* |
| **PiP** | Peephole | `media.peephole` | Accessibility label must remain *"Picture-in-Picture"* |
| **Chapters** | Phases | `media.phases` | Accessibility label must remain *"Chapters"* |
| **Home Feed** | Pad | Surface: Home | Screen title: *"Pad (Home)"* |
| **Shorts** | Pulses | Surface: Pulses | Screen title: *"Pulses"* |
| **Create** | Publish | Surface: Publish | Screen title: *"Publish"* |
| **Profile** | Persona | Surface: Persona | Screen title: *"Persona"* |

### 3.2 The Clarity Rule (Non-Negotiable)
- **Personality must NEVER destroy clarity or accessibility.**
- Screen readers, TalkBack, test tags, and tooltips must always convey the standard semantic meaning.
- Visual badges may use the personality label (e.g. "Pump" button), but the `contentDescription` must explicitly read "Like (Pump)".

---

## 4. Architectural Boundaries

### 4.1 Surface Ownership (One Page per AI Agent)
- Each major surface is owned by one specific agent:
  - `pages/home/` → **HOME_AGENT**
  - `pages/pulses/` → **PULSES_AGENT**
  - `pages/library/` → **LIBRARY_AGENT**
  - `pages/player/` → **PLAYER_AGENT**
  - `pages/music/` → **MUSIC_AGENT**
  - `pages/publish/` → **PUBLISH_AGENT**
  - `pages/studio/` → **STUDIO_AGENT**
  - `pages/persona/` → **PERSONA_AGENT**
  - `pages/devices/` → **DEVICES_AGENT**
  - `pages/servers/` → **SERVERS_AGENT**
  - `pages/search/` → **SEARCH_AGENT**
  - `pages/notifications/` → **NOTIFICATIONS_AGENT**
- An agent must **never** modify another agent's page directory.

### 4.2 Playback is a Global Subsystem
- Playback state belongs to `core/playback` and `services/playback`, exposed via the `PLAYER_AGENT`.
- Home, Library, and Pulses **consume** playback sessions. They do **not** invent their own player engines.

### 4.3 Trust Boundary: Discovered != Trusted
- Local LAN discovery (mDNS / SSDP) only detects an endpoint. It does not grant authority.
- Devices and Remote Servers must be explicitly authenticated and granted capability-scoped tokens.
- Remote servers must never receive unconstrained access to the user's primary Pulsy control plane.

### 4.4 Mini Apps vs Extensions
- **Mini App:** Self-contained application inside Pulsy with its own UI, state, configuration, and sandbox (e.g., Studio, Music, Podcasts).
- **Extension:** Modifies or hooks into existing core functionality or a Mini App (e.g., AI Subtitle Generator, FFmpeg Transcoder, YouTube Importer).

---

## 5. Agent Verification & Handoff Mandate

### 5.1 No Silent Hand-Offs
Every implementation session must conclude with:
1. An updated machine-readable `PAGE_MANIFEST.json` or `SERVICE_MANIFEST.json`.
2. A human-readable `PAGE_HANDOFF.md` in the owned directory.
3. Verification that tests pass and the Android project compiles cleanly via `compile_applet`.
4. Detailed entries in `CHANGELOG.md`.

---

*Any pull request, commit, or agent response that violates these rules must be rejected by the Integration Agent.*
