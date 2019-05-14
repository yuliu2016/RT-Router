package ca.warp7.rt.router.impl

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import java.io.File

object FileSystem {

    private val storePath = File(System.getProperty("user.home") + BuildConfig.kStorePath)

    init {
        if (!storePath.exists()) storePath.mkdirs()
    }

    private val properties: JsonObject
    private val configFile = File(storePath, BuildConfig.kPropertiesFile)

    init {
        configFile.createNewFile()
        properties = configFile.readText().trim().let {
            if (it.isEmpty()) JsonObject()
            else Parser.default().parse(StringBuilder(it)) as JsonObject
        }
    }

    fun getProperty(name: String): String? {
        return properties.string(name)
    }

    fun setProperty(name: String, value: String, save: Boolean) {
        properties[name] = value
        if (save) configFile.writeText(properties.toJsonString(prettyPrint = true))
    }

    fun getUserAgent(): String {
        return BuildConfig.kUserAgent
    }

    @Suppress("SENSELESS_COMPARISON")
    fun getTBAKey(): String? {
        val configKey = BuildConfig.tbaKey
        if (configKey != null) return configKey
        return getProperty("tbaKey")
    }
}