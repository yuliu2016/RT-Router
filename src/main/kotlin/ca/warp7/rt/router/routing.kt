@file:Suppress("unused", "ClassName")

package ca.warp7.rt.router

import ca.warp7.rt.router.impl.routeImpl
import kotlin.reflect.KProperty

object routing {
    operator fun get(endpoint: Any): RoutingDelegate {
        return routeImpl(endpoint)
    }

    operator fun get(vararg endpoint: Any): RoutingDelegate {
        return routeImpl(endpoint.asList())
    }

    operator fun getValue(ref: Any?, prop: KProperty<*>): RoutingDelegate {
        TODO()
    }
}
