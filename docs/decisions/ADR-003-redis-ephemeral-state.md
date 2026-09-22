# ADR-003: Redis for Ephemeral and High-Speed State

## Status
Accepted

## Context
Real-time playback tracking, active device heartbeats, LAN discovery presence, concurrent transcode locks, and live pairing handshakes produce high-frequency write operations (e.g. playback position updates every few seconds). Writing every transient tick directly to disk-bound PostgreSQL tables creates unnecessary I/O overhead and database bloat.

## Decision
Redis 7.x is designated for fast, short-lived, and in-memory state coordination:
1. Active session states (`session:playback:*`), device presence heartbeats (`presence:device:*`), distributed scanning locks (`lock:scan:*`), and temporary 6-digit pairing PINs live in Redis.
2. Redis is strictly non-durable: canonical entities and final historical checkpoints must be flushed to PostgreSQL.
3. If Redis restarts or evicts keys, the system must recover state gracefully from PostgreSQL.

## Consequences
- **Positive:** Sub-millisecond read/write latency for playback scrubbers and real-time cross-device remote control.
- **Positive:** Protects PostgreSQL from high-frequency write churn.
- **Negative:** Introduces a dual-store architecture requiring developers to understand which data belongs in Redis vs PostgreSQL.
