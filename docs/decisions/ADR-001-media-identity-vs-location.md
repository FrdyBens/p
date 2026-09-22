# ADR-001: Separation of Media Identity from Media Location

## Status
Accepted

## Context
In conventional media center applications (and basic player scripts), a media file is identified strictly by its absolute URI or filesystem path (e.g. `/storage/emulated/0/Movies/film.mp4` or `D:/Videos/film.mp4`). When a user moves the file to a different folder, reorganizes their NAS directory structure, or transfers it between a phone and a PC, the application treats the relocated file as a completely new media item. This results in the catastrophic loss of watch history, bookmarks, user ratings, playlist associations, and continue-watching timestamps.

## Decision
Pulsy enforces a strict architectural boundary between **Media Identity** and **Media Location**:
1. A canonical `MediaId` (`media_...`) represents the conceptual media work itself.
2. Physical file paths, SMB shares, and network streaming URLs are modeled as instances of `MediaSource` linked to the canonical `MediaId`.
3. Canonical deduplication and re-identification are performed via robust content fingerprinting (SHA-256 chunk hashing of media container headers and payload sample chunks).
4. Moving a file across folders or storage nodes triggers a rescan that re-associates the new `MediaLocation` with the existing `MediaId`, preserving all watch progress, playlists, and user metadata intact.

## Consequences
- **Positive:** Watch history, playlists, likes, and bookmarks survive disk reorganizations and cross-device syncing.
- **Positive:** Enables multi-source availability (e.g. if the local phone copy is deleted, Pulsy can seamlessly fall back to streaming from the home NAS for the same `MediaId`).
- **Negative:** Requires an ingestion scanner and fingerprinting pipeline rather than naive directory listing.
