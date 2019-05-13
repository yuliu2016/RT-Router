package test.ca.warp7.rt.router.tba

import ca.warp7.rt.router.internal.FileSystem
import ca.warp7.rt.router.tba.TBAV3Client
import org.junit.Test
import kotlin.test.assertTrue

class TBATest {

    private val key = FileSystem.getTBAKey()

    @Test
    fun basicRequestTest() {
        val tba = TBAV3Client(key!!)
        val request = tba.synchronousGet("status")
        assertTrue(request.isNotEmpty())
    }
}