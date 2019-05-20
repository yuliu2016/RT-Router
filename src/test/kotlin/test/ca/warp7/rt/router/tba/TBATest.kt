package test.ca.warp7.rt.router.tba

import ca.warp7.rt.router.tba.TBA
import kotlin.test.assertTrue

@Suppress("unused")
class TBATest {

    fun basicRequestTest() {
        val request = TBA.synchronousGet("/status")
        assertTrue(request.isNotEmpty())
    }
}