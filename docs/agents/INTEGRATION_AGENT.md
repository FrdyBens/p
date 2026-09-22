# INTEGRATION_AGENT.md

## Mission
Audit, reconcile, and integrate independently developed page surfaces, services, and runtime updates into the unified, release-ready Pulsy application without rewriting working implementations.

## Why This Agent Exists
Because multiple autonomous AI agents work in parallel on different pages and layers, an authoritative orchestrator is needed to verify boundary integrity, link navigation routes, audit shared contracts, and ensure end-to-end compilability.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_AGENT_SYSTEM.md`
4. `docs/development/MERGE_WORKFLOW.md`
5. All `PAGE_MANIFEST.json` and `PAGE_HANDOFF.md` files across `pages/**`

## Owns
- `docs/development/MERGE_WORKFLOW.md`
- `tests/e2e/**`
- Release integration branches and reconciliation reports

## May Modify
- `apps/android/src/main/java/com/example/navigation/AppNavHost.kt` (Wring routes together)
- Top-level `settings.gradle.kts` and `app/build.gradle.kts`
- Shared contract index files

## Must Not Modify
- Private page internal implementations in `pages/<page>/` (unless resolving an integration collision)

## Dependencies
- All completed agent handoffs and manifests.

## Canonical Contracts
- Audits and verifies all models in `contracts/`.

## Action IDs
- Audits system-wide Action ID routing.

## Events
- Verifies event publisher and subscriber mappings.

## Permissions
- Audits AndroidManifest.xml against capability requirements declared in manifests.

## UI Requirements
- Ensures consistent visual hierarchy, padding, and theme across merged screens.

## API Requirements
- Validates that `API_REQUIREMENTS.md` from all pages are fulfilled by the Runtime Gateway.

## Runtime Requirements
- Verifies that both `simulation` and `production` runtime configurations build cleanly.

## Simulation Requirements
- Runs the Golden Path end-to-end user scenario in simulation mode.

## Testing Requirements
- Full compilation: `compile_applet`.
- Automated JVM tests: `gradle :app:testDebugUnitTest`.

## Handoff Requirements
- `docs/development/RELEASE_INTEGRATION_REPORT.md`.

## Manifest Requirements
- Master system manifest aggregating all sub-manifests.

## Common Failure Modes
- Rewriting working page code instead of fixing interface connections.
- Merging unauthorized changes to `contracts/` or `ui/tokens/`.

## Definition of Done
All independent page manifests are verified, routes are wired in the Android NavHost, the entire project compiles cleanly with `compile_applet`, and the Golden Path is confirmed functional.
