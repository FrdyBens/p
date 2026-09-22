package contracts.enums

import kotlinx.serialization.Serializable

/**
 * Machine-readable capability and permission scopes for Pulsy.
 * Enforces explicit security boundaries (e.g. stream != download, discovered != trusted).
 */
@Serializable
object Permission {
    // Media Permissions
    const val MEDIA_READ = "media.read"
    const val MEDIA_SEARCH = "media.search"
    const val MEDIA_PLAY = "media.play"
    const val MEDIA_CREATE = "media.create"
    const val MEDIA_DELETE = "media.delete"

    // Playlist Permissions
    const val PLAYLIST_READ = "playlist.read"
    const val PLAYLIST_WRITE = "playlist.write"

    // Device Permissions
    const val DEVICE_DISCOVER = "device.discover"
    const val DEVICE_PAIR = "device.pair"
    const val DEVICE_CONTROL = "device.control"

    // Server Permissions
    const val SERVER_READ = "server.read"
    const val SERVER_STREAM = "server.stream"
    const val SERVER_DOWNLOAD = "server.download"
    const val SERVER_ADMIN = "server.admin"

    // Storage Permissions
    const val STORAGE_READ = "storage.read"
    const val STORAGE_WRITE = "storage.write"
    const val STORAGE_DOWNLOAD = "storage.download"

    // Network Permissions
    const val NETWORK_REMOTE = "network.remote"
    const val NETWORK_LOCAL = "network.local"

    val ALL_PERMISSIONS = listOf(
        MEDIA_READ, MEDIA_SEARCH, MEDIA_PLAY, MEDIA_CREATE, MEDIA_DELETE,
        PLAYLIST_READ, PLAYLIST_WRITE,
        DEVICE_DISCOVER, DEVICE_PAIR, DEVICE_CONTROL,
        SERVER_READ, SERVER_STREAM, SERVER_DOWNLOAD, SERVER_ADMIN,
        STORAGE_READ, STORAGE_WRITE, STORAGE_DOWNLOAD,
        NETWORK_REMOTE, NETWORK_LOCAL
    )
}
