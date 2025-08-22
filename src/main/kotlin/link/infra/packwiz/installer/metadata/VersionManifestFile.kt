package link.infra.packwiz.installer.metadata

data class VersionManifestFile(
    val id: String,
    val time: String,
    val releaseTime: String,
    val type: String,
    val mainClass: String,
    val inheritsFrom: String,
    val logging: Map<String, Any?>,
    val arguments: Arguments,
    val libraries: MutableList<Library>,
) {
    data class Arguments(
        val game: List<String>,
    )

    data class Library(
        val name: String,
        val downloads: Downloads,
    ) {
        data class Downloads(
            val artifact: Artifact,
        ) {
            data class Artifact(
                val path: String,
                val url: String,
                val sha1: String,
                val size: Int,
            )
        }
    }
}
