package ca.warp7.rt.router.simple

import ca.warp7.rt.router.*
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class SimpleContextDelegate : ReadOnlyProperty<Any?, SimpleContext> {
    private var simpleContext: SimpleContext? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): SimpleContext {
        val current = simpleContext
        val name = property.name
        return if (current == null) {
            val inst = SimpleRoutingContext(name)
            val delegateRef = routing[inst]
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

private class SimpleRoutingContext(override val contextName: String): RoutingContext {

    lateinit var simpleContext: SimpleContextImpl

    override var isActive: Boolean = false
    override val isDefined: Boolean = true
    override val hasData: Boolean
        get() = simpleContext.data.isEmpty()
    override var hasNewData: Boolean = false
    override val typing: Map<String, ColumnType>
        get() = simpleContext.typing
    override val data: Map<String, List<Any?>>
        get() = simpleContext.data
    override val added: Map<String, List<Any?>>
        get() = mapOf()
    override val deleted: Map<String, List<Any?>>
        get() = mapOf()
    override val changed: Map<String, List<Any?>>
        get() = mapOf()

    override fun update() {
    }

    override fun listen(listener: () -> Unit) {
    }

    override fun recycle() {
    }
}