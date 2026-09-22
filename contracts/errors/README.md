# Canonical Error Codes (`contracts/errors/`)

Standard error envelope:
```json
{
  "code": "ERROR_CODE",
  "message": "Human readable message",
  "domain": "MEDIA|AUTH|PLAYBACK|DEVICE|SYSTEM",
  "retryable": true,
  "details": {}
}
```

Standard codes:
- `UNAUTHENTICATED`
- `PERMISSION_DENIED`
- `NOT_FOUND`
- `MEDIA_UNAVAILABLE`
- `SOURCE_OFFLINE`
- `PLAYBACK_DECODE_ERR`
- `DEVICE_UNREACHABLE`
- `RATE_LIMITED`
- `CONFLICT`
- `INTERNAL_ERROR`
