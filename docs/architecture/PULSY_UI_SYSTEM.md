# PULSY — SHARED UI SYSTEM & DESIGN SYSTEM SPECIFICATION

> **Version:** 1.0.0  
> **Status:** RATIFIED  
> **Root Directory:** `/ui/`

---

## 1. Overview & Architectural Philosophy

Pulsy enforces a three-tier design system architecture:

```text
  DESIGN TOKENS (ui/tokens/)
         │
         ▼
  SHARED COMPONENTS (ui/components/)
         │
         ▼
  PAGE-SPECIFIC COMPOSITIONS (pages/<surface>/)
```

No page agent is allowed to invent private color palettes, custom touch-target dimensions, or arbitrary button styles. Every page is creatively composed using the shared design tokens and atomic components.

---

## 2. Design Tokens (`ui/tokens/`)

### 2.1 Color Tokens
Pulsy uses an OLED-optimized dark theme with dynamic neon accent pulses.

| Token Name | Hex Value | Semantic Role |
| :--- | :--- | :--- |
| `CanvasBackground` | `#0B0D13` | Deep obsidian background for all screens. |
| `SurfaceCard` | `#161922` | Card surface for media items, playlist rows. |
| `SurfaceElevated` | `#1F2432` | Bottom sheets, dialogs, floating action bars. |
| `SurfaceBorder` | `#2A3042` | 1.dp structural dividers and container borders. |
| `PulsePrimary` | `#8B5CF6` | Electric violet — primary actions, active tabs. |
| `PulseAccent` | `#06B6D4` | Pulse cyan — live stream badges, waveforms. |
| `PulseGradientStart`| `#7C3AED` | Start color for glowing buttons and hero banners.|
| `PulseGradientEnd` | `#06B6D4` | End color for glowing buttons and hero banners. |
| `TextHighContrast` | `#F8FAFC` | Main headings, video titles. |
| `TextMediumContrast`| `#94A3B8` | Metadata, creator names, view counts. |
| `TextMuted` | `#64748B` | Timestamps, inactive states, placeholder text. |
| `StatusLive` | `#EF4444` | Live streaming indicator, critical alerts. |
| `StatusSuccess` | `#10B981` | Download completed, device paired. |
| `StatusWarning` | `#F59E0B` | Buffer warning, low storage warning. |

### 2.2 Spacing Grid (8.dp System)
All padding and margins must use the standard spacing tokens:
- `Spacing.xxs` = `4.dp`
- `Spacing.xs`  = `8.dp`
- `Spacing.sm`  = `12.dp`
- `Spacing.md`  = `16.dp` (Standard screen horizontal padding)
- `Spacing.lg`  = `24.dp` (Section separation)
- `Spacing.xl`  = `32.dp` (Hero banner margins)
- `Spacing.xxl` = `48.dp` (Screen top/bottom boundaries)

### 2.3 Shapes & Corner Radii
- `Shape.Small`  = `RoundedCornerShape(8.dp)`  (Badges, tags, filter pills)
- `Shape.Medium` = `RoundedCornerShape(16.dp)` (Media cards, input text fields)
- `Shape.Large`  = `RoundedCornerShape(24.dp)` (Bottom sheets, modals)
- `Shape.Pill`   = `CircleShape`               (Avatars, FABs, floating bottom bar)

### 2.4 Touch Target Minimums
- **Universal Rule:** Every interactive component must have a touch target of at least **`48.dp x 48.dp`** (`Modifier.minimumInteractiveComponentSize()`).

---

## 3. Shared Components (`ui/components/`)

### 3.1 Decision Rule: Shared vs. Page-Local
A component belongs in `ui/components/` if:
1. It is used across two or more surfaces (e.g. `MediaCard`, `AvatarBadge`, `PulsyScrubber`, `StatusPill`).
2. It encapsulates a universal Pulsy behavior (e.g. pulsing animations, responsive loading shimmer).
3. It guarantees system-wide brand consistency.

A component stays page-local in `pages/<page>/components/` if:
1. It expresses logic unique to that screen (e.g. `StudioTimelineKeyframeTrack` or `PulsesVerticalSwipeScaffold`).

### 3.2 Canonical Shared Components
- `PulsyMediaCard`: 16:9 thumbnail, duration badge, title, channel avatar, view/timestamp row, overflow menu.
- `PulsyPulseCard`: 9:16 vertical card with floating action stack for Shorts.
- `PulsyButton`: Filled, outlined, or glowing gradient action button with haptic feedback.
- `PulsyIconButton`: Standardized 48.dp icon button with accessibility label.
- `PulsyScrubber`: Player progress bar with glowing thumb, buffered progress, and drag-seek callbacks.
- `PulsyBottomBar`: Floating pill-shaped navigation bar with blur effect and active pulse dot.
- `PulsyBottomSheet`: Draggable modal sheet with drag handle and nested scrolling support.
- `PulsyLoadingSkeleton`: Shimmering placeholder box for images and text lines.
- `PulsyEmptyState`: Empty illustration, friendly explanation, and primary action button.

---

## 4. Accessibility & Semantics

### 4.1 Content Descriptions (TalkBack Support)
Every image and interactive icon must include a non-null `contentDescription`.

```kotlin
// ✅ GOOD: Clear semantic label paired with personality
IconButton(
    onClick = { onAction(ActionId.SOCIAL_PUMP) },
    modifier = Modifier
        .testTag("action_pump")
        .minimumInteractiveComponentSize()
) {
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = stringResource(R.string.cd_action_pump) // "Like (Pump)"
    )
}
```

### 4.2 Dynamic Type & Font Scaling
Never use fixed pixel height containers for text. Always use Compose `sp` units and flexible column layouts (`Modifier.wrapContentHeight()`) to support Android system font scaling up to 200%.

---

## 5. Responsive Design & Window Size Classes

| Window Class | Form Factors | Layout Architecture |
| :--- | :--- | :--- |
| **Compact** (`< 600.dp`) | Standard Phones | 1-Column feed, floating bottom navigation bar. |
| **Medium** (`600.dp - 840.dp`)| Foldables, Small Tablets | 2-Column media grid, persistent navigation rail. |
| **Expanded** (`> 840.dp`) | Large Tablets, ChromeOS | 3-Column grid or List-Detail canonical layout with side player pane. |

---

## 6. Icons & Asset Conventions (`ui/icons/`)

Icons must use Material Symbols or custom vector drawables adhering to standard sizing:
- `IconSize.Small` = `16.dp` (inline metadata indicators)
- `IconSize.Medium` = `24.dp` (standard action buttons, bottom bar items)
- `IconSize.Large` = `32.dp` (player control buttons)
- `IconSize.Hero` = `48.dp` (central Pop/Puls FAB)
