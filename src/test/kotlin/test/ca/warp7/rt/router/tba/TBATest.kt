package test.ca.warp7.rt.router.tba

import ca.warp7.rt.router.impl.FileSystem
import ca.warp7.rt.router.tba.TBAV3Client
import org.junit.Test
import kotlin.test.assertTrue

@Suppress("unused")
class TBATest {

    private val key = FileSystem.getTBAKey()

    fun basicRequestTest() {
        val tba = TBAV3Client(key!!, FileSystem.getUserAgent())
        val request = tba.synchronousGet("/status")
        assertTrue(request.isNotEmpty())
    }
}