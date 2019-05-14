@file:Suppress("unused", "ClassName")

package ca.warp7.rt.router

import ca.warp7.rt.router.impl.routing0
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.reflect.KProperty

object routing {

    operator fun get(vararg endpoint: Any): RoutingDelegate {
        return routing0(endpoint.asList())
    }

    private val reflectionMutex = ReentrantLock()
    private val delegationMap = ConcurrentHashMap<String, RoutingDelegate>()

    operator fun getValue(ref: Any?, prop: KProperty<*>): RoutingContext {
        val name = prop.name
        reflectionMutex.withLock {
        }
        TODO()
    }

    fun search(by: Any): List<Any> {
        TODO()
    }

    val properties: RTProperties = TODO()
}
