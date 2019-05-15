package ca.warp7.rt.router.impl

import ca.warp7.rt.router.ColumnType
import ca.warp7.rt.router.RoutingContext
import ca.warp7.rt.router.SimpleContext
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class SimpleContextDelegate : ReadOnlyProperty<Any?, SimpleContext> {
    private var ref: SimpleContext? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): SimpleContext {
        val current = ref
        return if (current == null) {
            val inst = SimpleRoutingContext()
            val newRef = SimpleContextImpl(
                inst,
                mutableMapOf(),
                mutableMapOf()
            )
            ref = newRef
            newRef
        } else current
    }
}

private class SimpleContextImpl(
    override val actualContext: SimpleRoutingContext,
    override var data: MutableMap<String, List<Any?>>,
    override var typing: MutableMap<String, ColumnType>
) : SimpleContext {
    override fun notifyDataChanged() {
        actualContext.hasNewData = true
    }
}

private class SimpleRoutingContext: RoutingContext {
    override val contextName: String
        get() = TODO("not implemented")
    override val isActive: Boolean
        get() = TODO("not implemented")
    override val isDefined: Boolean
        get() = TODO("not implemented")
    override val hasData: Boolean
        get() = TODO("not implemented")
    override var hasNewData: Boolean = false
    override val isSingle: Boolean
        get() = TODO("not implemented")
    override val typing: Map<String, ColumnType>
        get() = TODO("not implemented")
    override val data: Map<String, List<Any?>>
        get() = TODO("not implemented")
    override val added: Map<String, List<Any?>>
        get() = TODO("not implemented")
    override val deleted: Map<String, List<Any?>>
        get() = TODO("not implemented")
    override val changed: Map<String, List<Any?>>
        get() = TODO("not implemented")

    override fun update() {
        TODO("not implemented")
    }

    override fun listen(listener: () -> Unit) {
        TODO("not implemented")
    }

    override fun progress(listener: () -> Unit) {
        TODO("not implemented")
    }

    override fun getFirst(): Any {
        TODO("not implemented")
    }

    override fun setAll(value: Any) {
        TODO("not implemented")
    }

    override fun select(columns: Set<String>, start: Int, end: Int): RoutingContext {
        TODO("not implemented")
    }

    override fun recycle() {
        TODO("not implemented")
    }
}