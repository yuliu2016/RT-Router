package ca.warp7.rt.router.tba

import ca.warp7.rt.router.impl.ConfigSystem
import com.github.kittinunf.fuel.httpGet

object TBAV3Client {

    fun synchronousGet(request: String): String {
        return synchronousGet(request, defaultParams)
    }

    fun synchronousGet(request: String, params: TBAQueryParams): String {
        return (kAPIRoot + params.format(request)).httpGet()
            .header("X-TBA-Auth-Key" to kAuthKey!!, "User-Agent" to kUserAgent).responseString().third.get()
    }

    var defaultParams = TBAQueryParams()

    private const val kAPIRoot = "http://www.thebluealliance.com/api/v3"
    var kAuthKey = ConfigSystem.getTBAKey()
    var kUserAgent = ConfigSystem.getUserAgent()
}