# RUNTIME_AGENT.md

## Mission
Build and maintain the client-side runtime abstraction in `runtime/` (`PulsyRuntime`), seamlessly switching between `simulation` (n8n dev bridge) and `production` (native backend) while exposing a uniform interface to the UI.

## Why This Agent Exists
To decouple the Android UI layer from backend deployment details. The UI must never know or care whether it is talking to an n8n webhook or a native microservice.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_ARCHITECTURE.md`
3. `docs/development/DEVELOPMENT_WORKFLOW.md`
4. `docs/decisions/ADR-004-n8n-development-bridge.md`

## Owns
- `runtime/**`
  - `runtime/simulation/**`
  - `runtime/production/**`
  - `runtime/README.md`

## May Modify
- `runtime/**`
- `tests/integration/runtime/**`

## Must Not Modify
- `pages/**`
- `services/**`
- `ui/**`

## Dependencies
- `contracts/**` for type-safe envelopes.
- Retrofit / OkHttp client configuration in `apps/android`.

## Canonical Contracts
- Exposes `invoke(actionId: String, payload: T): PulsyResponse<R>`.

## Models
- Wraps canonical models without alteration.

## Action IDs
- Dispatches all Action IDs to appropriate network handlers.

## Events
- Exposes Kotlin `SharedFlow` / WebSocket event stream to client ViewModels.

## Permissions
- Injects `Authorization: Bearer <token>` into outbound requests.

## UI Requirements
- None.

## API Requirements
- Implements network client adapters for both n8n and native HTTP/WebSocket endpoints.

## Runtime Requirements
- Manages connection retry, offline queueing, and network error mapping.

## Simulation Requirements
- Format requests to match n8n webhook schema when `PULSY_RUNTIME_MODE=simulation`.

## Testing Requirements
- MockWebServer tests verifying clean switching between simulation and production modes.

## Handoff Requirements
- `RUNTIME_HANDOFF.md` in `runtime/`.

## Manifest Requirements
- `SERVICE_MANIFEST.json` in `runtime/`.

## Common Failure Modes
- Leaking n8n-specific response shapes to the UI.
- Direct database connection attempts.

## Definition of Done
`PulsyRuntime` is implemented, injectable into ViewModels, and supports both modes with robust error recovery.
