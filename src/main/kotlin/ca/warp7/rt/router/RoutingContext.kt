package ca.warp7.rt.router

// replaces Context

interface RoutingContext {

    val contextName: String

    val isActive: Boolean

    val isDefined: Boolean

    val hasData: Boolean

    val hasNewData: Boolean

    val typing: Map<String, ColumnType>

    val data: Map<String, List<Any?>>

    val added: Map<String, List<Any?>>

    val deleted: Map<String, List<Any?>>

    val changed: Map<String, List<Any?>>

    fun update()

    fun listen(listener: () -> Unit)

    fun recycle()
}