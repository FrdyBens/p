# Canonical Responses (`contracts/responses/`)

Universal response envelopes and domain operation payloads.

## Structure
- `PulsyResponse.kt` / `PulsyResponse.ts`: Uniform response envelope (`PulsyResponse<T>`).
- `Pagination.kt` / `Pagination.ts`: `PageInfo` cursor descriptor and `PaginationResponse<T>` wrapper.
- `PlaybackResponses.kt` / `PlaybackResponses.ts`: Active playback session and playback source resolution responses.
- `MediaResponses.kt` / `MediaResponses.ts`: Canonical Media and MediaSource detail, list, scan, and registration responses.
- `PlaylistResponses.kt` / `PlaylistResponses.ts`: Packup detail and list responses.
- `DeviceResponses.kt` / `DeviceResponses.ts`: Device status, list, and pairing responses.
- `ServerResponses.kt` / `ServerResponses.ts`: Media server status and discovery responses.
- `SearchResponses.kt` / `SearchResponses.ts`: Aggregated search results and facet metadata.
- `FeedResponses.kt` / `FeedResponses.ts`: Paginated feed payloads for Home and Pulses.

## Rules
1. Every successful API response wraps domain data in `PulsyResponse<T>` with `status = "OK"`.
2. Every failure response sets `status = "ERROR"` and populates the canonical `error: PulsyError`.
