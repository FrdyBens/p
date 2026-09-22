# Canonical Errors (`contracts/errors/`)

Standard error formats and machine-readable error codes.

## Structure
- `ErrorCode.kt` / `ErrorCode.ts`: Finite, actionable error classification enum.
- `PulsyError.kt` / `PulsyError.ts`: Uniform error envelope returned across all services, runtimes, and client boundaries.

## Rules
1. Never return unstructured string error messages directly to the UI.
2. The UI handles errors based on the deterministic `code` and `retryable` properties.
3. Secret connection strings, internal server traces, or database credentials must NEVER be placed in `message` or `details`.
