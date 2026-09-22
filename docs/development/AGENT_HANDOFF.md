# PULSY — AGENT HANDOFF SPECIFICATION

> **Version:** 1.0.0  
> **Status:** MANDATORY  
> **Applies to:** All Implementation Agents Finishing a Session

---

## 1. Overview

Because development in Pulsy is distributed across multiple autonomous AI sessions, **structured documentation is just as critical as executable code**. 

An agent must never stop a turn by simply saying "I am done." Every agent must leave behind complete, machine-readable and human-readable handoff documentation that allows the **Integration Agent** or the next developer to understand every modification, contract dependency, and tested behavior.

---

## 2. The 30 Standard Handoff Data Points

Every completion report (`PAGE_HANDOFF.md` or `SERVICE_HANDOFF.md`) must explicitly address the following 30 points:

1. **Agent Identity**: Name of agent (e.g. `HOME_AGENT`).
2. **Instruction Version**: Version of agent Markdown spec used.
3. **Date / Timestamp**: UTC timestamp of completion.
4. **Scope Delivered**: Summary of requested tasks completed.
5. **Files Created**: List of new files added.
6. **Files Modified**: List of existing files changed.
7. **Files Deleted**: List of files removed (if any).
8. **Files Intentionally Preserved**: Existing files reviewed and left unchanged.
9. **Components Created**: Composable or architectural components built.
10. **Action IDs Implemented**: List of Action IDs wired up.
11. **Contracts Consumed**: Models from `contracts/` imported.
12. **Contracts Created / Proposed**: Any new contract proposals.
13. **API Dependencies**: Endpoints or runtime calls expected.
14. **Events Consumed**: Bus events subscribed to.
15. **Events Emitted**: Bus events published.
16. **Permissions Required**: Android or capability scopes required.
17. **Navigation Routes**: Route IDs registered in NavHost.
18. **State Management**: ViewModels, StateFlows, or Room DAOs used.
19. **Simulation Behavior**: How the feature behaves in n8n/simulation mode.
20. **Production Dependencies**: Services required for production.
21. **Media Requirements**: Supported media types, codecs, or aspect ratios.
22. **External Dependencies**: Libraries referenced.
23. **Configuration Required**: `.env` keys or settings needed.
24. **Known Limitations**: Intentional edge cases not yet covered.
25. **Technical Debt**: Temporary shortcuts documented for future cleanup.
26. **Tests Performed**: Unit tests, Robolectric tests, or build passes.
27. **Tests Not Performed**: Scenarios deferred to integration phase.
28. **Known Conflicts**: Potential collisions with adjacent pages.
29. **Integration Notes**: Specific instructions for the `INTEGRATION_AGENT`.
30. **What the Next Agent Needs to Know**: Critical context for whoever touches this code next.

---

## 3. Required File Artifacts

Each page or service directory must contain:

```text
pages/<surface>/
├── PAGE_HANDOFF.md        # Human-readable report covering the 30 points
├── PAGE_MANIFEST.json     # Machine-readable schema-validated manifest
├── API_REQUIREMENTS.md    # Endpoints requested from backend/runtime
├── TESTS.md               # Test coverage and verification logs
└── CHANGELOG.md           # Continuous ledger of modifications
```
