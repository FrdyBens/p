package contracts.models

import kotlinx.serialization.Serializable

/**
 * Manifest contract for internal Mini Apps (Music, Studio, Podcast, Radio, etc.).
 * Mini Apps consume canonical contracts without inventing competing global models.
 */
@Serializable
data class MiniAppManifest(
    val id: String,                 // e.g. "app.pulsy.music", "app.pulsy.studio"
    val name: String,               // "Music", "Studio"
    val version: String,            // "1.0.0"
    val requiredCoreVersion: String,// "1.0.0"
    val description: String,
    val iconUri: String,
    val entryRoute: String,         // e.g. "mini_app/music"
    val permissions: List<String> = emptyList(), // e.g. ["media.read", "media.play", "playlist.write"]
    val capabilities: List<String> = emptyList(),
    val isEnabled: Boolean = true
)
