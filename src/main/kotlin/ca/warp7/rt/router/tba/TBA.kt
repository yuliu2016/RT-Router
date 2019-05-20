package ca.warp7.rt.router.tba

import ca.warp7.rt.router.impl.ConfigSystem
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.github.kittinunf.fuel.core.await
import com.github.kittinunf.fuel.core.awaitResponse
import com.github.kittinunf.fuel.core.requests.suspendable
import com.github.kittinunf.fuel.httpGet
import java.lang.StringBuilder

object TBA {

    fun synchronousGet(request: String): String {
        return synchronousGet(request, defaultParams)
    }

    fun synchronousGet(request: String, params: TBAQueryParams): String {
        return (kAPIRoot + params.format(request)).httpGet()
            .header("X-TBA-Auth-Key" to kAuthKey!!, "User-Agent" to kUserAgent).responseString().third.get()
    }

    suspend fun get(request: String): Map<String, Any?> {
        val response = (kAPIRoot + request).httpGet()
            .header("X-TBA-Auth-Key" to kAuthKey!!, "User-Agent" to kUserAgent)
            .suspendable().awaitResult().get().responseMessage
        return Parser.default().parse(StringBuilder(response)) as JsonObject
    }

    var defaultParams = TBAQueryParams()

    private const val kAPIRoot = "http://www.thebluealliance.com/api/v3"
    var kAuthKey = ConfigSystem.getTBAKey()
    var kUserAgent = ConfigSystem.getUserAgent()
}