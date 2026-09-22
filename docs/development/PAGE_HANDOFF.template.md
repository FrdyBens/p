# PAGE HANDOFF — [PAGE_NAME]

> **Agent:** [AGENT_ID] (e.g. `HOME_AGENT`)  
> **Instruction Version:** 1.0.0  
> **Date:** [YYYY-MM-DDTHH:MM:SSZ]  
> **Status:** READY_FOR_INTEGRATION  

---

## 1. Executive Summary & Scope
- **Scope Implemented:** [Brief bullet points of what was completed]
- **Surface:** `pages/[surface]/`

---

## 2. File Operations
- **Files Created:**
  - `pages/[surface]/...`
- **Files Modified:**
  - None (or list within owned path)
- **Files Deleted:**
  - None
- **Files Intentionally Preserved:**
  - `pages/[surface]/README.md`

---

## 3. Contracts, Actions & Events
- **Action IDs Implemented:**
  - `[action.id]`
- **Contracts Consumed:**
  - `[ContractName]` (`contracts/models/...`)
- **Contracts Created / Proposed:**
  - None
- **Events Consumed:**
  - `[event.name]`
- **Events Emitted:**
  - `[event.name]`

---

## 4. UI Components & Tokens Used
- **Shared Components Used:**
  - `PulsyMediaCard`, `PulsyButton`, etc.
- **Page-Local Components Created:**
  - `[PageSpecificComponent]`
- **Tokens Referenced:**
  - `CanvasBackground`, `PulsePrimary`, `Spacing.md`, etc.
- **Touch Target Verification:** All targets verified >= 48.dp x 48.dp.

---

## 5. Runtime & API Dependencies
- **Simulation Behavior (n8n):** [Describe how it runs against n8n dev bridge]
- **Production Endpoints Required:** [List API endpoints expected from Backend Agent]
- **Permissions Required:** [List Android / Capability scopes]

---

## 6. Testing & Quality Assurance
- **Tests Executed:**
  - Unit / Robolectric test names
- **Tests Deferred:**
  - End-to-end multi-device sync
- **Compilation Check:** Verified via `compile_applet`.

---

## 7. Known Issues & Notes for Integration Agent
- **Limitations:** [Document edge cases or mock fixtures used]
- **Integration Instructions:** [Notes on routing or NavHost wiring]
- **What the Next Agent Needs to Know:** [Context for future agents]
