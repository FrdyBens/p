# Canonical Requests (`contracts/requests/`)

Standard client-to-service and UI-to-runtime request models.

## Structure
- `PulsyRequest.kt` / `PulsyRequest.ts`: Universal typed request envelope (`PulsyRequest<T>`).
- `Pagination.kt` / `Pagination.ts`: Canonical cursor-based pagination parameters.
- `PlaybackRequests.kt` / `PlaybackRequests.ts`: Requests for playback controls (`PlayMediaRequest`, `SeekRequest`, `HandoffRequest`, etc.).
- `MediaRequests.kt` / `MediaRequests.ts`: Media query, registration, scanning, and upload requests.
- `PlaylistRequests.kt` / `PlaylistRequests.ts`: Packup creation, mutation, and item reordering requests.
- `DeviceRequests.kt` / `DeviceRequests.ts`: Device discovery, pairing, and connection requests.
- `ServerRequests.kt` / `ServerRequests.ts`: Media server connection, discovery, and scan triggers.
- `SearchRequests.kt` / `SearchRequests.ts`: Universal search query, filtering, and sorting parameters.
- `FeedRequests.kt` / `FeedRequests.ts`: Feed ingestion requests for Home and Pulses.

## Rules
1. All client calls must pass through `PulsyRequest<T>` or typed service methods.
2. Actions referenced in requests must use constants from `ActionId`.
