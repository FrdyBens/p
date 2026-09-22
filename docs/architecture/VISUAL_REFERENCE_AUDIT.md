# PULSY — VISUAL REFERENCE AUDIT & DESIGN ANALYSIS

> **Audit Date:** 2026-09-22  
> **Source Evidence:** 9 high-resolution Android screenshots (`com.aistudio.streampulse.kxdvpy`, 1080x2400) located at repository root.  
> **Purpose:** Extract design strengths, eliminate flaws, and establish shared design tokens and component standards.

---

## 1. Overview of Evaluated Visual References

The repository contains nine sequential reference captures representing early prototype explorations:

1. **`Screenshot_...14-57-35-687` (Pad / Home Feed):**
   - Hero banner at top with high-energy backdrop, prominent title, animated pulsing play badge.
   - Horizontal category chips ("All", "Gaming", "Synthwave", "LAN Streams", "Podcasts").
   - 16:9 media cards with channel avatars, view counters, duration badges, and overflow action dots.
2. **`Screenshot_...14-57-45-071` (Filter & Search State):**
   - Active search bar with clear icon, auto-complete tags, recent query pills, and focused surface elevation.
3. **`Screenshot_...14-57-49-216` (Pulses / Vertical Shorts):**
   - Edge-to-edge 9:16 vertical video player.
   - Right-aligned floating action rail: Pump (heart/flame), Punch (dislike), Patter (comments), Pass-Pulse (share), Sound disk.
   - Clean gradient scrim at bottom with creator handle, audio track marquee, and subscribe pill.
4. **`Screenshot_...14-57-55-282` (Pocket / Library):**
   - Grid layout of downloads, watch history carousel with progress bars, and custom Packups (playlists).
   - Storage utilization bar showing local vs server allocation.
5. **`Screenshot_...14-57-59-839` (Patter / Comments & Details Sheet):**
   - Draggable bottom sheet with rounded top corners (24.dp).
   - Tabbed segments for "Overview" and "Patter (Comments)".
   - Clean nested comment hierarchy with timestamps and heart counters.
6. **`Screenshot_...14-58-06-843` (Active Player Surface):**
   - Landscape/portrait reactive player frame.
   - Glowing audio/video scrubber with dynamic buffer track.
   - Personality control bar: Pop/Puls (central large FAB), Pulse-Pass (+10s), Pulse-Prior (-10s), Pace (1.0x), Puff-Up (fullscreen).
7. **`Screenshot_...14-58-10-408` (Nodes & Discovery):**
   - Card list of discovered LAN devices (Pixel 9, Shield TV, Mac Mini) and active servers (TrueNAS, Jellyfin).
   - Status indicators (Green pulse for active stream, Amber for standby).
8. **`Screenshot_...14-58-21-221` (Persona / Profile Hub):**
   - Creator banner, circular avatar with glowing border accent, subscriber counters, stats cards (Total Pumps, Hours Streamed).
9. **`Screenshot_...14-58-27-243` (Studio / Quick Action Dialog):**
   - Modal action sheet for creating a new Pulse, recording, uploading local file, or configuring playback server.

---

## 2. In-Depth Visual Analysis

### 2.1 Color Palette & Contrast
- **Base Canvas:** Deep OLED-safe obsidian background (`#0B0D13` to `#12151F`). Eliminates eye strain and optimizes battery on modern AMOLED panels.
- **Surface Elevation:** Subtle tinted dark surfaces (`#181B26` for cards, `#202535` for modals) with low-opacity borders (`#2D3349`) rather than drop shadows.
- **Vibrant Accent (The "Pulse"):** Electric neon violet/magenta (`#7C3AED` to `#A855F7`) paired with pulse cyan (`#06B6D4` / `#00F0FF`). Used intentionally for primary actions, active playback scrubbers, and live status badges.
- **Text Contrast:** High-contrast off-white (`#F8FAFC`) for titles, muted slate (`#94A3B8`) for secondary metadata, and dim grey (`#64748B`) for timestamps.

### 2.2 Typography Rhythm
- **Headings:** Bold modern sans-serif with slight tracking compression (-0.5sp) for tight, punchy headlines.
- **Body & Data:** Clean neutral sans-serif with generous line height (1.4x) for readability on dense cards.
- **Badges & Durations:** Monospace or tabular figures for duration stamps (`14:20`) to prevent jitter during playback.

### 2.3 Spacing, Density & Grid
- **Rhythm:** Consistent 8.dp baseline grid. Margins of 16.dp on mobile, 8.dp to 12.dp gaps between cards.
- **Card Corners:** Rounded corners with a uniform 16.dp radius on standard media cards, 12.dp on chips/badges, and 28.dp on bottom navigation bars and floating buttons.

---

## 3. Preserved Strengths vs. Areas for Improvement

### A. What is Worth Preserving (Core DNA)
1. **The "Pulse" Atmosphere:** The glowing gradient accents and living status indicators give the app a distinct, energetic identity that feels premium.
2. **Edge-to-Edge Immersion:** Deep dark surfaces that extend fully behind navigation and status bars (`enableEdgeToEdge`).
3. **Floating Navigation Bar:** The pill-shaped floating bottom bar with smooth blurred backdrop blur (glassmorphism/surface tint).
4. **Scannable Card Hierarchy:** Media cards clearly separate thumbnail, duration, title, channel avatar, and view count without clutter.
5. **Universal Scrubber & Waveform:** The player's dynamic scrubber with glowing playhead and secondary buffer track.

### B. What Should Be Improved (Fixes Required)
1. **Touch Target Accessibility:** Some inline action icons (overflow dots, filter pills) were approximately 32.dp in the prototype. All interactive targets must enforce the **minimum 48.dp x 48.dp** touch standard.
2. **Text Hierarchy in Subtitles:** Secondary text on small devices occasionally crowded against card edges. Require a minimum 12.dp horizontal margin inside container cards.
3. **Inconsistent Border Radii:** The prototype mixed 8.dp, 14.dp, and 20.dp inconsistently. We must standardize to strict token classes: `Small` (8.dp), `Medium` (16.dp), `Large` (24.dp), `Pill` (999.dp).
4. **Loading & Empty State Treatment:** Prototype lacked explicit placeholder skeletons. Standardized animated shimmering gradient skeletons must be defined.

### C. What Should NOT Become a Hard Rule
1. **Strict 1-Column Layout:** Tablets and landscape mode must adapt to multi-column grids (2-column on Foldables, 3-column on Tablets), rather than stretching a single column.
2. **Fixed Card Heights:** Card heights should flex with font scaling settings rather than using hardcoded pixel heights.
3. **Identical Screen Clones:** Different surfaces (Home vs Library vs Studio vs Music) should have distinct layouts tailored to their media type while sharing design tokens.

### D. Shared Design Tokens to Codify
- `PulsyColorPalette` (Obsidian canvas, Tinted card, Pulse Violet, Pulse Cyan, Success Green, Danger Coral).
- `PulsySpacing` (xxs: 4.dp, xs: 8.dp, sm: 12.dp, md: 16.dp, lg: 24.dp, xl: 32.dp).
- `PulsyShapes` (small: 8.dp, medium: 16.dp, large: 24.dp, full: 999.dp).
- `PulsyTouchTarget` (minimum: 48.dp).
- `PulsyElevation` (Level 0: canvas, Level 1: cards, Level 2: sheets/dialogs, Level 3: floating controls).
