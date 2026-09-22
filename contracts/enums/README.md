# Canonical Enums (`contracts/enums/`)

This directory contains the universal enumeration definitions and controlled vocabularies for Pulsy.

## Definitions
- `ActionId.kt` / `ActionId.ts`: Dot-notated canonical identifiers for every interactive user and system operation.
- `MediaKind.kt` / `MediaType.kt` / `MediaKind.ts`: Supported media classifications (`VIDEO`, `AUDIO`, `SHORT_PULSE`, `LIVE_STREAM`, `PODCAST`).
- `SourceProtocol.kt` / `SourceProtocol.ts`: Streaming and storage transport protocols (`FILE`, `SMB`, `HTTP`, `HTTPS`, `HLS`, `DASH`, `WEBRTC`).
- `SourceType.kt` / `SourceType.ts`: Categorization of media locations (`LOCAL_FILE`, `LAN_SERVER`, `PERSONAL_SERVER`, `COMMUNITY_SERVER`, `REMOTE_URL`).
- `DeviceType.kt` / `DeviceType.ts`: Client device classifications (`PHONE`, `TABLET`, `TV`, `DESKTOP`, `CAR`, `EMBEDDED`, `BROWSER`).
- `DeviceStatus.kt` / `DeviceStatus.ts`: Device operational state (`ONLINE`, `OFFLINE`, `UNPAIRED`, `PAIRING`, `BUSY`).
- `ServerType.kt` / `ServerType.ts`: Media server topologies (`PERSONAL_NAS`, `COMMUNITY`, `CLOUD_RELAY`).
- `ServerStatus.kt` / `ServerStatus.ts`: Server connectivity state (`ONLINE`, `OFFLINE`, `CONNECTING`, `UNREACHABLE`, `UNAUTHORIZED`).
- `PlaybackState.kt` / `PlaybackState.ts`: Player session state (`IDLE`, `BUFFERING`, `POP`, `PULS`, `PLOP`, `COMPLETED`, `ERROR`).
- `RepeatMode.kt` / `RepeatMode.ts`: Queue repetition behavior (`OFF`, `ONE`, `ALL`).
- `HandoffState.kt` / `HandoffState.ts`: Device playback transfer lifecycle state (`REQUESTED`, `PREPARING`, `TRANSFERRING`, `COMPLETED`, `FAILED`, `CANCELLED`).
- `NotificationType.kt` / `NotificationType.ts`: Inbox notification classifications.
- `Permission.kt` / `Permission.ts`: Machine-readable capability and authorization scopes.
- `SearchResultType.kt` / `SearchResultType.ts`: Domain entity classifications for universal search.
- `PersonalityVocabulary.kt` / `PersonalityVocabulary.ts`: Mapping table between brand personality terms and standard semantics/Action IDs (ADR-008).
