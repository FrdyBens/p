# PULSY — MERGE & INTEGRATION WORKFLOW

> **Version:** 1.0.0  
> **Status:** RATIFIED  
> **Primary Actor:** `INTEGRATION_AGENT`

---

## 1. The Merge Philosophy

Merging independently built AI Studio branches or parallel agent tasks into the universal Pulsy application **does NOT mean rewriting everything from scratch**. 

Instead, the `INTEGRATION_AGENT` follows a structured reconciliation protocol based on **machine-readable manifests** and **ownership boundaries**:

```text
               INDEPENDENT AGENT SESSIONS
       ┌───────────────────┬───────────────────┐
       ▼                   ▼                   ▼
   HOME_AGENT        PLAYER_AGENT        LIBRARY_AGENT
  (manifest +         (manifest +         (manifest +
    handoff)            handoff)            handoff)
       │                   │                   │
       └───────────────────┼───────────────────┘
                           │
                           ▼
                 INTEGRATION PROTOCOL
   [1] Inspect & Validate Manifests (JSON schema)
   [2] Verify Ownership Boundaries (No illegal touches)
   [3] Audit Shared Contracts & Models
   [4] Reconcile Navigation Routes in NavHost
   [5] Validate Reusable Components in `ui/components/`
   [6] Run Full Compilation (`compile_applet`)
   [7] Execute End-to-End CUJ Test Suite
                           │
                           ▼
               UNIVERSAL PULSY RELEASE
```

---

## 2. Step-by-Step Integration Protocol

### Step 1: Manifest Inspection
The Integration Agent scans all `PAGE_MANIFEST.json` and `SERVICE_MANIFEST.json` files.
- Checks:
  - Do any two agents claim ownership of the same file?
  - Are all declared `contractsConsumed` actually present in `contracts/`?
  - Are all `routes` globally unique?

### Step 2: Ownership Violation Audit
If an agent modified a file outside its declared `ownedPaths`:
- The Integration Agent flags the diff.
- If the change was an unauthorized edit to another page, it is reverted.
- If the change was a proposed fix to a shared component in `ui/components/`, the Integration Agent reviews it for backward compatibility before merging.

### Step 3: Navigation Reconciler
The Integration Agent updates the top-level Android navigation graph (`AppNavHost.kt`):
- Connects routes declared in each page's manifest into the central navigation hierarchy.
- Wires the floating bottom navigation bar items (`Pad`, `Pulses`, `Publish`, `Pocket`, `Persona`).

### Step 4: Verification & Compilation
- Executes `compile_applet` to ensure zero compilation or linking errors.
- Runs local Robolectric JVM tests across all merged surfaces.
- Verifies the **Golden Path** user journey.
