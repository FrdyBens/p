# MEDIA_SERVER_AGENT.md

## Mission
Design, specify, and provide deployment tooling for the real test media server used during development and testing of ExoPlayer/Media3 streaming, byte-range seeking, buffering, and variant transcoding.

## Why This Agent Exists
Testing media playback against fake URLs or simulated timers does not verify real video codecs, seek responsiveness, network buffer exhaustion, or HTTP 206 range requests. A real media streaming server is mandatory test infrastructure.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_ARCHITECTURE.md`
3. `docs/development/DEVELOPMENT_WORKFLOW.md`

## Owns
- `services/media/server/**`
- `docs/development/TEST_MEDIA_SERVER.md`

## May Modify
- Test media manifests in `tests/fixtures/media/**`.

## Must Not Modify
- `pages/**`
- `ui/**`
- `core/playback/**`

## Dependencies
- Standard HTTP/HLS streaming server (e.g. lightweight Go / Node / Nginx container).

## Canonical Contracts
- Media source URL format conforming to `contracts/models/MediaSource.kt`.

## Models
- `MediaSource`, `MediaVariant`.

## Action IDs
- `media.scan`, `media.inspect`.

## Events
- Emits stream health metrics.

## Permissions
- Validates stream authorization tokens if configured.

## UI Requirements
- None.

## API Requirements
- Implements:
  - `GET /media/{mediaId}/stream` (HTTP 206 Partial Content support)
  - `GET /media/{mediaId}/hls/manifest.m3u8`
  - `HEAD /media/{mediaId}/stream` (Content-Length and Accept-Ranges headers)

## Runtime Requirements
- Low-latency byte-range responses (<50ms on LAN).

## Simulation Requirements
- Provide pre-packaged test video and audio files (1080p MP4, vertical 9:16 Pulse, AAC audio).

## Testing Requirements
- Range request header validation tests (`curl -H "Range: bytes=0-1024"`).

## Handoff Requirements
- `MEDIA_SERVER_HANDOFF.md` in `services/media/server/`.

## Manifest Requirements
- `SERVICE_MANIFEST.json`.

## Common Failure Modes
- Forgetting HTTP `206 Partial Content` support, breaking ExoPlayer seek functionality.
- Using expired or unplayable third-party test video links.

## Definition of Done
A self-hosted test media streaming daemon with standard test media files is fully documented and deployable.
