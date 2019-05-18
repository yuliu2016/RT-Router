@file:Suppress("unused", "ClassName")

package ca.warp7.rt.router

import ca.warp7.rt.router.impl._byRoute
import ca.warp7.rt.router.util.ColumnType
import ca.warp7.rt.router.util.DelegateOf
import kotlin.reflect.KProperty

object routing {

    operator fun get(vararg endpoints: Any): RoutingDelegate {
        val endpointList = endpoints.toList()
        val res = _byRoute(endpointList)
        val first = res.firstOrNull()
        if (first?.isDefined == true) return first.delegate
        throw IllegalStateException("Unable to route into $endpointList")
    }

    fun search(by: String): List<Any> {
        return _byRoute(listOf(by))
    }

    private const val kLengthThreshold: Int = 10

    private val transitives: MutableMap<String, DelegateOf<RoutingContext>> = mutableMapOf()
    private val transitiveLock = Any()

    operator fun getValue(thisRef: Any?, property: KProperty<*>): RoutingContext {
        val name = property.name
        return synchronized(transitiveLock) {
            (transitives[name] ?: (get(name) as DelegateOf<RoutingContext>)
                .also { transitives[name] = it }).getValue(thisRef, property)
        }
    }

    val simpleContext: DelegateOf<SimpleContext> get() = SimpleContextDelegate()

    class SimpleContextDelegate : DelegateOf<SimpleContext> {
        private var simpleContext: SimpleContext? = null
        override fun getValue(thisRef: Any?, property: KProperty<*>): SimpleContext {
            val current = simpleContext
            val name = property.name
            return if (current == null) {
                val inst = SimpleRoutingContext(name)
                val delegateRef = get(inst)
                val newRef = SimpleContextImpl(
                    delegateRef,
                    mutableMapOf(),
                    mutableMapOf()
                )
                inst.simpleContext = newRef
                simpleContext = newRef
                newRef
            } else current
        }
    }

    private class SimpleContextImpl(
        delegate: RoutingDelegate,
        override var data: MutableMap<String, List<Any?>>,
        override var typing: MutableMap<String, ColumnType>
    ) : SimpleContext {
        override val actualContext: RoutingContext by delegate
        val innerContext get() = actualContext as SimpleRoutingContext
        override fun notifyDataChanged() {
            innerContext.hasNewData = true
        }
    }

    private class SimpleRoutingContext(override val name: String) : RoutingContext {

        lateinit var simpleContext: SimpleContextImpl

        override var isActive: Boolean = false
        override val isDefined: Boolean = true
        override var hasNewData: Boolean = false
        override val typing: Map<String, ColumnType>
            get() = simpleContext.typing
        override val data: Map<String, List<Any?>>
            get() = simpleContext.data

        override fun update() {
        }

        override fun listen(listener: () -> Unit) {
        }

        override fun recycle() {
        }
    }
}