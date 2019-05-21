package ca.warp7.rt.router.tba

import ca.warp7.rt.router.impl.ConfigSystem
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonBase
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.coroutines.awaitString

private suspend fun TBA.getParsed(requestURL: String): JsonBase {
    val response = Fuel
        .get("http://www.thebluealliance.com/api/v3$requestURL")
        .header("X-TBA-Auth-Key" to authKey!!, "User-Agent" to ConfigSystem.getUserAgent())
        .awaitString()
    return Parser.default().parse(StringBuilder(response)) as JsonBase
}

internal suspend fun TBA.get(requestURL: String): JsonObject {
    return getParsed(requestURL) as JsonObject
}

internal suspend fun TBA.getArray(requestURL: String): JsonArray<*> {
    return getParsed(requestURL) as JsonArray<*>
}