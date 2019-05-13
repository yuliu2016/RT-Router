package ca.warp7.rt.router.tba

import com.github.kittinunf.fuel.httpGet

class TBAV3Client(private val authKey: String) {

    fun synchronousGet(request: String): String{
        return (kAPIRoot + request).httpGet()
            .header("X-TBA-Auth-Key" to authKey, "User-Agent" to "Hi").responseString().third.get()
    }
}