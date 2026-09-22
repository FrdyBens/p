# PULSY — AGENT STARTUP PROTOCOL

> **Version:** 1.0.0  
> **Status:** MANDATORY  
> **Target:** Autonomous AI Agents and Contributing Developers

---

## 1. The Startup Sequence

Before writing a single line of code or creating any file, every agent **MUST** complete these 10 steps:

```text
       ┌────────────────────────────────────────────────────────┐
       │ STEP 1: Verify Git & Environment Integrity             │
       └──────────────────────────┬─────────────────────────────┘
                                  ▼
       ┌────────────────────────────────────────────────────────┐
       │ STEP 2: Read `docs/agents/MASTER_AGENT.md`             │
       └──────────────────────────┬─────────────────────────────┘
                                  ▼
       ┌────────────────────────────────────────────────────────┐
       │ STEP 3: Read your assigned `docs/agents/<AGENT>.md`     │
       └──────────────────────────┬─────────────────────────────┘
                                  ▼
       ┌────────────────────────────────────────────────────────┐
       │ STEP 4: Inspect Owned Paths vs. Forbidden Paths        │
       └──────────────────────────┬─────────────────────────────┘
                                  ▼
       ┌────────────────────────────────────────────────────────┐
       │ STEP 5: Search `contracts/` for existing models/APIs    │
       └──────────────────────────┬─────────────────────────────┘
                                  ▼
       ┌────────────────────────────────────────────────────────┐
       │ STEP 6: Search `ui/components/` & `ui/tokens/`          │
       └──────────────────────────┬─────────────────────────────┘
                                  ▼
       ┌────────────────────────────────────────────────────────┐
       │ STEP 7: Check assigned Action IDs and Events            │
       └──────────────────────────┬─────────────────────────────┘
                                  ▼
       ┌────────────────────────────────────────────────────────┐
       │ STEP 8: Read existing files in your owned directory     │
       └──────────────────────────┬─────────────────────────────┘
                                  ▼
       ┌────────────────────────────────────────────────────────┐
       │ STEP 9: Review `API_REQUIREMENTS.md` & `CHANGELOG.md`   │
       └──────────────────────────┬─────────────────────────────┘
                                  ▼
       ┌────────────────────────────────────────────────────────┐
       │ STEP 10: Ready to Implement                            │
       └────────────────────────────────────────────────────────┘
```

---

## 2. Checklists by Step

### Step 1: Verify Git
- Confirm branch is up to date with `origin/main`.
- Verify no untracked secrets (`.env` with real credentials) are about to be staged.

### Step 2 & 3: Read Agent Specifications
- Read `docs/agents/MASTER_AGENT.md` completely.
- Read your assigned agent file (e.g. `docs/agents/HOME_AGENT.md`).

### Step 4: Verify Boundaries
- Double-check: Am I about to touch a file outside my **OWNS** directory?
- If yes, **STOP**. You must not edit files belonging to other pages or core systems without explicit assignment.

### Step 5: Reuse Existing Contracts
- Do **not** create a local `Media` class in your page folder.
- Use `import contracts.models.Media`.

### Step 6: Reuse Existing UI Tokens
- Do **not** hardcode colors like `Color(0xFF8B5CF6)`.
- Use `PulsyTheme.colorScheme.primary` or `PulsyTokens.PulsePrimary`.
- Ensure all interactive elements have `Modifier.minimumInteractiveComponentSize()` (48.dp).

---

## 3. Ambiguity Resolution

If you encounter an ambiguity during startup:
1. Search `docs/decisions/` (ADRs) to see if the question was already resolved.
2. Search `docs/architecture/` for domain rules.
3. If still unresolved, record the decision in your `PAGE_HANDOFF.md` under **"Decisions Made & Unresolved Questions"** rather than silently guessing.
