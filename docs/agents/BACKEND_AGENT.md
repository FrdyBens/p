# BACKEND_AGENT.md

## Mission
Develop, maintain, and optimize the native Pulsy control plane services in `services/` (Auth, Media, Device, Server, Discovery, Playback, Playlist, Search).

## Why This Agent Exists
To provide high-performance, secure backend services that execute business logic, manage Redis ephemeral state, query PostgreSQL, and expose REST/gRPC/WebSocket APIs.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_ARCHITECTURE.md`
3. `docs/architecture/PULSY_COMMUNICATION.md`
4. `docs/decisions/ADR-005-unified-control-plane.md`

## Owns
- `services/**`
  - `services/media/**`
  - `services/playback/**`
  - `services/device/**`
  - `services/server/**`
  - `services/discovery/**`
  - `services/search/**`
- `core/**`

## May Modify
- `services/**`
- `core/**`
- `api/**`

## Must Not Modify
- `pages/**`
- `ui/**`
- `database/migrations/**` (Requests changes from DATABASE_AGENT)

## Dependencies
- Canonical contracts from `CONTRACTS_AGENT`.
- Relational schema from `DATABASE_AGENT`.
- Redis 7.x instance.

## Canonical Contracts
- Implements endpoints fulfilling `contracts/requests/` and `contracts/responses/`.

## Models
- Consumes all domain models from `contracts/models/`.

## Action IDs
- Full routing for all canonical Action IDs.

## Events
- Publishes lifecycle events to Redis Pub/Sub / WebSocket channels.

## Permissions
- Enforces capability token validation on all endpoints.

## UI Requirements
- None.

## API Requirements
- Maintain `api/v1/` route definitions.

## Runtime Requirements
- High-concurrency async processing (Node.js / Ktor / Go).

## Simulation Requirements
- Support coexistence with n8n dev bridge endpoints.

## Testing Requirements
- Unit tests for domain logic and integration tests against Redis and PostgreSQL.

## Handoff Requirements
- `BACKEND_HANDOFF.md` in `services/`.
- API documentation in `api/README.md`.

## Manifest Requirements
- `SERVICE_MANIFEST.json` in `services/`.

## Common Failure Modes
- Creating separate backend processes for different pages (violating the 1-control-plane rule).
- Hardcoding secrets.

## Definition of Done
Core services handle all major Action IDs with real database queries, Redis caching, and error handling.
