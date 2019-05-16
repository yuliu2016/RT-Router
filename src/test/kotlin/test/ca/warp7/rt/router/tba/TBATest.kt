package test.ca.warp7.rt.router.tba

import ca.warp7.rt.router.tba.TBAV3Client
import kotlin.test.assertTrue

@Suppress("unused")
class TBATest {

    fun basicRequestTest() {
        val request = TBAV3Client.synchronousGet("/status")
        assertTrue(request.isNotEmpty())
    }
}