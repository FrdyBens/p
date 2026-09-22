# ADR-002: PostgreSQL as the Durable Source of Truth

## Status
Accepted

## Context
Pulsy manages complex relational entities including user personas, device registries, authorized servers, media catalogs, multi-source mappings, custom playlists, granular watch histories, and capability-based permissions. Using unstructured JSON files or flat file databases for core persistence leads to race conditions, corruption during abrupt shutdowns, and lack of referential integrity.

## Decision
PostgreSQL 16.x (`pulsy_dev`) is adopted as the single, authoritative persistent source of truth:
1. All durable entities (users, devices, servers, media, sources, playlists, history, ACLs) must be persisted in PostgreSQL.
2. Direct connection or SQL query execution from the client UI is strictly forbidden; all interactions occur through the Pulsy Runtime / Service Gateway.
3. Schema evolutions must be managed exclusively through sequential, numbered SQL migration scripts in `database/migrations/`.
4. Production credentials are never committed to Git and are supplied via environment secrets.

## Consequences
- **Positive:** Guarantees ACID compliance, foreign key integrity, transactional security, and enterprise-grade querying for complex media catalogs.
- **Positive:** Establishes a real, professional database backend rather than mock JSON files.
- **Negative:** Requires PostgreSQL infrastructure to be running during development testing.
