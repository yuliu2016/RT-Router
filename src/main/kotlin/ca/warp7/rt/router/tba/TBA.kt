package ca.warp7.rt.router.tba

import ca.warp7.rt.router.impl.ConfigSystem
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.coroutines.awaitString

object TBA {

    suspend fun get(requestURL: String): JsonObject {
        val response = Fuel
            .get("http://www.thebluealliance.com/api/v3$requestURL")
            .header("X-TBA-Auth-Key" to kAuthKey!!, "User-Agent" to ConfigSystem.getUserAgent())
            .awaitString()
        return Parser.default().parse(StringBuilder(response)) as JsonObject
    }

    @Suppress("MemberVisibilityCanBePrivate")
    var kAuthKey: String? = ConfigSystem.getTBAKey()
}