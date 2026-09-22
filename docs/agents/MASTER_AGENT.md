# MASTER_AGENT.md — UNIVERSAL PREAMBLE & AGENT GOVERNANCE

> **MANDATORY READING:** Every AI agent, prompt session, and human engineer working on Pulsy **MUST** read this document before creating or modifying any file.

---

## 1. Pulsy Identity & Core Philosophy

Pulsy is a distributed personal media ecosystem, Android-first, built on the core tenet:
> *"Nothing is ever still. If it is on screen, it has a pulse."*

It bridges local offline storage, personal LAN media servers (NAS, Jellyfin, Plex), remote community servers, and creator streaming into a single, unified, living interface.

---

## 2. Universal Rules of Engagement

### 2.1 Git is the Single Source of Truth
- The Git repository (`https://github.com/FrdyBens/p`) is canonical.
- **NEVER** create an alternative folder layout, duplicate repository, or rename canonical root directories (`contracts`, `core`, `database`, `docs`, `pages`, `runtime`, `services`, `ui`, `apps`, `tests`).

### 2.2 Media Identity != Media Location
- The logical media entity (`MediaId`) is completely decoupled from physical file paths or URLs.
- Moving, renaming, or transferring a file across devices must **never** break watch history, playlists, or bookmarks.

### 2.3 Strict Bounded Ownership
- You own **ONLY** the paths explicitly designated in your assigned agent file.
- You are strictly forbidden from modifying files in directories owned by other agents.
- Cross-surface features must be invoked via standard **Action IDs** or shared **Contracts**, never by copying another page's implementation.

### 2.4 Strict UI Isolation
- **The UI must NEVER connect directly to PostgreSQL or Redis.**
- Never execute raw SQL queries from client Composables.
- All client data flows pass through the **Pulsy Runtime / Service Gateway**.

### 2.5 Zero Secrets in Git
- Never commit credentials, tokens, or private keys to the repository.
- Use environment variables (`.env` mapped via BuildConfig/Secrets panel).

### 2.6 The Clarity Rule
- Pulsy uses an energetic "P" personality vocabulary (Pop, Puls, Plop, Pass, Prior, Pump, Punch, Packup, Pocket, Pad, Pulses, Persona).
- **Personality must NEVER compromise accessibility, Action IDs, or test tags.**
- Tooltips, `contentDescription`, and Action IDs must always communicate the clear semantic meaning.

---

## 3. The 10-Step Execution Protocol

1. **Read Assigned File:** Read your assigned agent file (e.g. `docs/agents/HOME_AGENT.md`).
2. **Review Boundaries:** Confirm your `OWNS` vs `MUST NOT MODIFY` directories.
3. **Inspect Contracts:** Check `contracts/` for existing models before writing new data structures.
4. **Inspect UI System:** Check `ui/tokens/` and `ui/components/` before creating custom widgets.
5. **Enforce Touch Minimums:** Ensure every clickable element is at least `48.dp x 48.dp`.
6. **Implement Owned Scope:** Write clean, modular Kotlin/Compose or TypeScript code within your boundary.
7. **Compile & Verify:** Verify that changes compile cleanly with `compile_applet`.
8. **Generate Manifest:** Write an updated, schema-validated `PAGE_MANIFEST.json` or `SERVICE_MANIFEST.json`.
9. **Write Handoff:** Produce a detailed `PAGE_HANDOFF.md` covering the 30 standard points.
10. **Record Changelog:** Append concise, timestamped change notes in `CHANGELOG.md`.

---

## 4. Resolving Ambiguity

If an architectural decision is unclear:
1. Consult `docs/architecture/PULSY_RULES.md` and `docs/decisions/` (ADRs).
2. Do not invent an uncoordinated third path.
3. Record the chosen implementation and rationale in your `PAGE_HANDOFF.md` under **"Decisions Made & Notes for Integration Agent"**.
