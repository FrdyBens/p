# Pulsy Canonical Contracts

> **Version:** 1.0.0  
> **Status:** RATIFIED & BINDING  
> **Authority:** Pulsy Contracts Agent

This directory defines the **shared language of Pulsy** across Android (Kotlin `@Serializable`), Web/Desktop (TypeScript), backend services, and runtime simulations.

---

## Architectural Principles

1. **MEDIA IDENTITY != MEDIA LOCATION (The Cardinal Law)**:
   - `Media` (`media_...`) models the conceptual work.
   - `MediaSource` (`src_...`) models where the media can currently be accessed (local phone, NAS, remote community server).
   - Moving or renaming files preserves watch history, bookmarks, ratings, and playlists.
2. **DURABLE VS. EPHEMERAL STATE**:
   - PostgreSQL is the durable source of truth.
   - Redis manages fast ephemeral state (presence, locks, short-lived session coordination).
   - UI clients NEVER directly access databases or Redis.
3. **STRICT TYPING & VERSIONING**:
   - All models adhere to `v1.0.0`. Breaking changes require explicit major versioning.
   - New fields must be optional or defaulted.
4. **PERSONALITY WITH ACCESSIBILITY**:
   - "P" terminology (Pop, Puls, Plop, Pump, Punch, Packup, Pocket, Pad, Pulses, Persona) is mapped cleanly in `contracts.enums.PersonalityVocabulary`.
   - Action IDs remain semantic and deterministic (`media.pop`, `social.pump`).
   - Screen reader labels (`contentDescription`) remain standard for accessibility.

---

## Directory Index

```text
contracts/
├── enums/             # Controlled vocabularies & constant definitions
│   ├── ActionId       # Canonical Action ID registry
│   ├── MediaKind      # MediaType classifications
│   ├── SourceProtocol # Transport protocols (FILE, SMB, HTTP, HLS, etc.)
│   ├── SourceType     # Source origins (LOCAL_FILE, LAN_SERVER, etc.)
│   ├── DeviceType     # Hardware categories
│   ├── DeviceStatus   # Connection states
│   ├── ServerType     # Server architectures
│   ├── ServerStatus   # Server health states
│   ├── PlaybackState  # Player session states (POP, PULS, PLOP, etc.)
│   ├── RepeatMode     # OFF, ONE, ALL
│   ├── HandoffState   # Playback continuity lifecycle
│   ├── NotificationType # Inbox alert kinds
│   ├── Permission     # Machine-readable capability scopes
│   ├── SearchResultType # Search result categories
│   └── PersonalityVocabulary # Brand term to semantic action mapping
├── errors/            # Standard error shapes
│   ├── ErrorCode      # Canonical domain failure codes
│   └── PulsyError     # Universal error envelope
├── models/            # Core domain entities
│   ├── User & Persona # Profile, creator stats, public identity
│   ├── Device         # Client endpoint model
│   ├── Server         # Storage/media node model
│   ├── Media          # Logical media identity (zero file paths)
│   ├── MediaSource    # Physical access endpoint
│   ├── MediaVariant   # Codec, resolution, container definition
│   ├── MediaTracks    # Multi-track audio, subtitles, video, chapters
│   ├── IdentityEvidence # Cryptographic content fingerprinting
│   ├── PlaybackSession# Real-time player state
│   ├── PlaybackPosition # Timecode synchronization
│   ├── PlaybackQueue  # Media queue
│   ├── PlaybackCapabilities # Device rendering support
│   ├── HandoffPayload # Seamless device-to-device continuity
│   ├── Playlist & PlaylistItem # User-curated packups
│   ├── HistoryEntry   # Durable watch progress
│   ├── LibraryEntry   # User bookmarks & downloads
│   ├── Notification   # User inbox alerts
│   ├── SearchResult   # Multi-entity search record
│   ├── FeedItem       # Home/Pulses feed card wrapper
│   └── MiniAppManifest# Mini-app plugin contract
├── requests/          # Action input schemas
│   ├── PulsyRequest   # Generic request envelope
│   ├── PlaybackRequests # PlayMedia, Seek, Pace, Volume, Handoff
│   ├── MediaRequests  # Scan, Registration, Upload, Publish
│   ├── PlaylistRequests # Packup creation, mutation, reordering
│   ├── DeviceRequests # Discovery, pairing, connection
│   ├── ServerRequests # Discovery, connection, scan
│   ├── SearchRequests # Query, filters, sorting
│   ├── FeedRequests   # Feed ingestion
│   └── Pagination     # Cursor pagination request
├── responses/         # Action output schemas
│   ├── PulsyResponse  # Generic response envelope
│   ├── PlaybackResponses # Session & source resolution
│   ├── MediaResponses # Media detail, scan results, lists
│   ├── PlaylistResponses # Packup payloads
│   ├── DeviceResponses # Device status & pairing
│   ├── ServerResponses # Server details
│   ├── SearchResponses # Search results & facets
│   ├── FeedResponses  # Feed item bundles
│   └── Pagination     # PageInfo & PaginationResponse
└── events/            # Asynchronous domain events
    ├── PulsyEvent     # Generic event envelope
    └── DomainEvents   # Playback, device, server, and media lifecycle events
```

---

## Agent Usage Instructions

When implementing features:
1. **Never invent private copies** of `Media`, `Device`, `User`, `Playlist`, etc.
2. For Android: `import contracts.models.*`, `import contracts.enums.*`, `import contracts.requests.*`, `import contracts.responses.*`.
3. For Web/Desktop/Node: `import { Media } from "../contracts/models/Media"`.
4. Ensure all user interaction points trigger standard `ActionId` constants.
