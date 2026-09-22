# NOTIFICATIONS_AGENT.md

## Mission
Build and maintain the Notifications surface in `pages/notifications/`, managing creator upload alerts, live stream announcements, LAN device pairing requests, and background download completion notices.

## Why This Agent Exists
To provide users with an organized inbox for real-time and asynchronous alerts across their subscriptions and network nodes.

## Reads First
1. `docs/agents/MASTER_AGENT.md`
2. `docs/architecture/PULSY_RULES.md`
3. `docs/architecture/PULSY_COMMUNICATION.md`

## Owns
- `pages/notifications/**`
  - `pages/notifications/NotificationsScreen.kt`
  - `pages/notifications/NotificationsViewModel.kt`
  - `pages/notifications/components/**`
  - `pages/notifications/PAGE_HANDOFF.md`
  - `pages/notifications/PAGE_MANIFEST.json`
  - `pages/notifications/CHANGELOG.md`

## May Modify
- `pages/notifications/**`

## Must Not Modify
- `pages/home/**`
- `services/notifications/**`
- `database/**`

## Dependencies
- Canonical `Notification` model.
- Shared components from `ui/components/`.

## Canonical Contracts
- `Notification`, `NotificationType`.

## Action IDs
- `notification.read`: Mark notification as viewed.
- `notification.dismiss`: Remove alert from feed.
- `notification.action`: Deep-link to target media or device pairing dialog.

## Events
- Consumes: `notification.received`.

## Permissions
- Android `POST_NOTIFICATIONS` runtime permission.

## UI Requirements
- Clean notification list grouped by "Today", "This Week", and "Earlier".
- Avatars/thumbnails next to each notice with colored badge indicator.
- Swipe-to-dismiss gesture on notification cards.
- "Mark All as Read" header button.
- 48.dp minimum touch targets.

## API Requirements
- `runtime.getNotifications(): List<Notification>`
- `runtime.markNotificationRead(id: String)`
- `runtime.dismissNotification(id: String)`

## Runtime Requirements
- Integration with Android system notification tray when app is backgrounded.

## Simulation Requirements
- Provide 4 sample notifications (New upload from subscribed channel, Device pairing request, Download completed).

## Testing Requirements
- Swipe dismiss callback tests and unread count badge unit tests.

## Handoff Requirements
- `PAGE_HANDOFF.md` and `PAGE_MANIFEST.json` in `pages/notifications/`.

## Manifest Requirements
- Valid schema adhering to `docs/development/manifest.schema.json`.

## Common Failure Modes
- Prompting for notification permissions prematurely during initial app launch instead of contextually.
- Missing deep-link handling for tapped notifications.

## Definition of Done
Notifications screen displays grouped alerts, supports swipe-to-dismiss, handles deep-links, and compiles cleanly.
