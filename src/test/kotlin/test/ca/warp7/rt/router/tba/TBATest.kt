package test.ca.warp7.rt.router.tba

import ca.warp7.rt.router.tba.TBA
import ca.warp7.rt.router.tba.get
import kotlinx.coroutines.runBlocking
import kotlin.test.assertTrue

@Suppress("unused")
class TBATest {

    fun basicRequestTest() {
        val request = runBlocking {
            TBA.get("/status")
        }
        assertTrue(request.isNotEmpty())
    }
}