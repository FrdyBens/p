# DATABASE_AGENT.md

## Mission
Design and maintain the PostgreSQL 16 schema, tables, indexes, constraints, migrations, and seeds in `database/`, serving as the single durable source of truth for Pulsy.

## Why This Agent Exists
To ensure durable data integrity, ACID transactional guarantees, foreign key safety, and high-performance querying without polluting UI code with SQL logic.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/decisions/ADR-002-postgresql-source-of-truth.md`
4. `docs/architecture/PULSY_CONTRACTS.md`

## Owns
- `database/**`
  - `database/migrations/**`
  - `database/seeds/**`
  - `database/docs/**`
  - `database/README.md`

## May Modify
- `database/**`
- `tests/integration/database/**`

## Must Not Modify
- `pages/**` (Strict UI isolation)
- `ui/**`
- `contracts/**` (Reads models as reference)

## Dependencies
- PostgreSQL 16.x (`pulsy_dev`).
- Canonical contracts from `CONTRACTS_AGENT`.

## Canonical Contracts
- Consumes all models from `contracts/models/` and maps them to relational DDL.

## Models
- Tables for `users`, `personas`, `devices`, `servers`, `media`, `media_sources`, `media_variants`, `playlists`, `playlist_items`, `history`, `permissions`.

## Action IDs
- Database operations backing all canonical Action IDs.

## Events
- PostgreSQL `NOTIFY` triggers or transactional outbox patterns for event dispatch.

## Permissions
- Store capability grants and role bindings in `permissions` table.

## UI Requirements
- None.

## API Requirements
- Document required SQL queries for consumption by Backend Agent and n8n bridge.

## Runtime Requirements
- Standard connection pooling (HikariCP / pgBouncer).

## Simulation Requirements
- Provide deterministic seed scripts in `database/seeds/dev_seed.sql` for local testing.

## Testing Requirements
- Migration rollback and execution tests in `tests/integration/database/`.

## Handoff Requirements
- `DATABASE_HANDOFF.md` in `database/`.
- Schema diagram in `database/docs/SCHEMA.md`.

## Manifest Requirements
- `SERVICE_MANIFEST.json` in `database/`.

## Common Failure Modes
- Committing database passwords to files.
- Modifying previously applied migrations instead of creating a new sequential migration.

## Definition of Done
All relational tables, unique hash indexes on `media.canonical_hash`, and seed scripts are written and tested.
