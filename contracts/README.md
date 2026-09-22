# Canonical Contracts Index

This directory contains the universal, versioned data contracts for the Pulsy ecosystem.

## Structure
- `models/`: Canonical data entities (Media, MediaSource, Device, Server, User, Playlist, HistoryEntry).
- `requests/`: Standard client-to-runtime request envelopes (`PulsyRequest<T>`).
- `responses/`: Standard runtime-to-client response envelopes (`PulsyResponse<T>`).
- `events/`: Asynchronous domain lifecycle events (`PulsyEvent<T>`).
- `errors/`: Structured error types and domain failure codes.
- `enums/`: Canonical enumerations (PlaybackState, MediaType, SourceProtocol, DeviceType).

## Rules
1. **Never create page-local copies of global models.** Use `import contracts.models.Media`.
2. All Kotlin classes must be annotated with `@Serializable`.
3. Changes must be backward-compatible (new fields optional or defaulted).
