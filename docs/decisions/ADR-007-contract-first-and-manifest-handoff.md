# ADR-007: Contract-First Development and Machine-Readable Manifest Handoffs

## Status
Accepted

## Context
In an autonomous multi-agent ecosystem, informal verbal promises or freeform chat summaries between agents lead to breaking API drift, mismatched data schemas, and missing endpoints. A formal, verifiable interface protocol is required.

## Decision
Pulsy enforces **Contract-First Development & Manifest Handoffs**:
1. All domain models, requests, responses, events, and error codes must be committed to `contracts/` before feature implementations depend on them.
2. Every agent completing an implementation session must generate a schema-validated `PAGE_MANIFEST.json` or `SERVICE_MANIFEST.json` in its owned root.
3. The manifest explicitly enumerates: `agentId`, `ownedPaths`, `createdFiles`, `modifiedFiles`, `actions`, `contractsConsumed`, `routes`, and `handoffStatus`.
4. A companion human-readable `PAGE_HANDOFF.md` must cover the 30 standard handoff data points.
5. Merging is performed by an authoritative `INTEGRATION_AGENT` that inspects manifests and verifies zero ownership collisions.

## Consequences
- **Positive:** Complete visibility into every change across the entire project.
- **Positive:** Enables automated CI/CD and Integration Agents to validate interface compatibility deterministically.
- **Negative:** Agents must complete both code and documentation deliverables before finishing.
