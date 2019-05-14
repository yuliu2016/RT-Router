@file:Suppress("unused", "ClassName")

package ca.warp7.rt.router

import ca.warp7.rt.router.impl.routeImpl
import kotlin.reflect.KProperty

object routing {

    operator fun get(vararg endpoint: Any): RoutingDelegate {
        return routeImpl(endpoint.asList())
    }

    operator fun getValue(ref: Any?, prop: KProperty<*>): RoutingContext {
        TODO()
    }

    fun search(by: Any): List<Any> {
        TODO()
    }

    val properties: RTProperties = TODO()
}
