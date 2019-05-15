@file:Suppress("unused", "ClassName")

package ca.warp7.rt.router

import ca.warp7.rt.router.simple.SimpleContextDelegate
import ca.warp7.rt.router.impl.checkedVararg
import ca.warp7.rt.router.impl.routing0
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

object routing {

    operator fun get(vararg endpoints: Any): RoutingDelegate {
        val endpointList = endpoints.toList()
        val res = routing0(checkedVararg(endpointList))
        val first = res.firstOrNull()
        if (first?.isDefined == true) return first.delegate
        throw IllegalStateException("Unable to route into $endpointList")
    }

    fun search(by: String): List<Any> {
        return routing0(listOf(by))
    }

    private val transitives: MutableMap<String, ReadOnlyProperty<Any?, RoutingContext>> = mutableMapOf()
    private val transitiveMutex = Any()

    operator fun getValue(thisRef: Any?, property: KProperty<*>): RoutingContext {
        val name = property.name
        return synchronized(transitiveMutex) {
            val v = transitives[name]
            val delegate = if (v == null) {
                val inst = get(name) as ReadOnlyProperty<Any?, RoutingContext>
                transitives[name] = inst
                inst
            } else v
            delegate.getValue(thisRef, property)
        }
    }

    val simpleContext: ReadOnlyProperty<Any?, SimpleContext> get() = SimpleContextDelegate()
}
