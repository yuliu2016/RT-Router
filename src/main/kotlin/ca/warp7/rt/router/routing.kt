@file:Suppress("unused", "ClassName")

package ca.warp7.rt.router

import ca.warp7.rt.router.impl.SimpleContextDelegate
import ca.warp7.rt.router.impl.routing0
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

object routing {

    operator fun get(vararg endpoints: Any): RoutingDelegate {
        val list = endpoints.toList()
        val res = routing0(list)
        if (res.isNotEmpty() && res.first().isDefined) {
            return res.first().delegate
        }
        throw IllegalStateException("Unable to route into $list")
    }

    fun search(by: String): List<Any> {
        return routing0(listOf(by))
    }

    private val transitives: MutableMap<String, RoutingDelegate> = mutableMapOf()
    private val transitiveMutex = Any()

    operator fun getValue(thisRef: Any?, property: KProperty<*>): RoutingContext {
        val name = property.name
        return synchronized(transitiveMutex) {
            val v = transitives[name]
            val delegate = if (v == null) {
                val inst = get(name)
                transitives[name] = inst
                inst
            } else v
            delegate.getValue(thisRef, property)
        }
    }

    val simpleContext: ReadOnlyProperty<Any?, SimpleContext> get() = SimpleContextDelegate()
}
