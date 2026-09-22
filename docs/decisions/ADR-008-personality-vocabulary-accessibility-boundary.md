# ADR-008: Personality Vocabulary vs. Semantic Accessibility Boundary

## Status
Accepted

## Context
Pulsy possesses a distinctive brand personality inspired by the core philosophy: *"Nothing is ever still. If it is on screen, it has a pulse."* The app uses an alliterative "P" vocabulary for actions and surfaces (Pop, Puls, Plop, Pass, Prior, Pump, Punch, Packup, Pocket, Pad, Pulses, Persona). While this creates strong brand differentiation, if used carelessly, it risks destroying user accessibility, confusing TalkBack screen readers, breaking internationalization, and obfuscating programmatic Action IDs.

## Decision
Pulsy enforces a strict boundary between **Visual Personality** and **Underlying Semantics**:
1. **Action IDs are Standardized:** Programmatic Action IDs and contract methods must remain clear and semantic (e.g. `media.pop`, `media.puls`, `media.seek`, `social.pump`).
2. **Accessibility Semantics are Universal:** All Compose `contentDescription` attributes, TalkBack announcements, and test tags must state the standard semantic action. For example, a "Pump" button must have `contentDescription = "Like (Pump)"` and `Modifier.testTag("action_pump")`.
3. **Screen Titles Pair Personality with Function:** High-level headers must communicate clear context (e.g. "Pad — Home Feed", "Pocket — Library & Downloads").
4. **No Ad-Hoc Terminology:** Future agents are strictly prohibited from inventing arbitrary "P" words. Only words defined in `docs/architecture/PULSY_RULES.md` are canonical.

## Consequences
- **Positive:** Preserves the dynamic, modern brand identity while meeting strict WCAG 2.1 AA accessibility and Android accessibility standards.
- **Positive:** TalkBack users and automated test harnesses can seamlessly navigate and test the UI.
- **Negative:** Agents must explicitly verify both the visual label and the accessibility content description.
