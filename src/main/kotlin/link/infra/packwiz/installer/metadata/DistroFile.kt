package link.infra.packwiz.installer.metadata

import com.google.gson.annotations.SerializedName

data class DistroFile(
    var version: String,
    var servers: List<Server>,
) {
    data class Server(
        var id: String,
        var name: String,
        var description: String,
        var icon: String,
        var version: String,
        var address: String,
        var minecraftVersion: String,
        var mainServer: Boolean,
        var autoconnect: Boolean,
        var modules: MutableList<Module>?,
    ) {
        data class Module(
            var id: String,
            var name: String,
            var type: ModuleType,
            var classpath: Boolean?,
            var artifact: Artifact,
            var subModules: List<Module>?,
        ) {
            enum class ModuleType(val value: String) {
                @SerializedName("File")
                FILE("File"),
                @SerializedName("Library")
                LIBRARY("Library")
            }

            data class Artifact(
                var size: Int,
                var url: String,
                var MD5: String,
                var path: String?,
            ) {}
        }
    }
}