# ADR-004: n8n as Development and Testing Bridge

## Status
Accepted

## Context
During early multi-agent development, standing up a fully fledged native microservices backend for every developer and AI Studio session is slow and resource-heavy. The developer already possesses verified, working n8n workflows that bridge HTTP webhooks directly to PostgreSQL 16 and Redis.

## Decision
n8n is established as the **Development & Testing Bridge**:
1. In development (`MODE = "simulation"`), the `PulsyRuntime` routes client requests to n8n webhook endpoints that execute queries against `pulsy_dev` PostgreSQL and Redis.
2. In production (`MODE = "production"`), the exact same client runtime calls the high-performance native backend service suite.
3. n8n is strictly an infrastructure bridge. The client UI code must never import n8n SDKs, reference n8n workflows directly, or depend on n8n-specific quirks.
4. All webhook URLs and tokens are injected via `.env` configuration.

## Consequences
- **Positive:** Enables instant end-to-end integration testing against real PostgreSQL and Redis databases without waiting for full backend microservices to be compiled.
- **Positive:** Hides infrastructure details behind the `PulsyRuntime` gateway.
- **Negative:** n8n endpoints must strictly adhere to the canonical Pulsy request/response envelopes.
