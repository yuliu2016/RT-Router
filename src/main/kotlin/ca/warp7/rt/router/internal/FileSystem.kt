package ca.warp7.rt.router.internal

import java.io.File

object FileSystem {

    val storePath = File(System.getProperty("user.home") + BuildConfig.kStorePath)

    init {
        if (!storePath.exists()) {
            storePath.mkdirs()
        }
    }
}