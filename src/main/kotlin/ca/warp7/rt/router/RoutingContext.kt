package ca.warp7.rt.router

// replaces Context

interface RoutingContext {

    val contextName: String

    val isActive: Boolean

    val isDefined: Boolean

    val hasData: Boolean

    val hasNewData: Boolean

    val isSingle: Boolean

    var isEager: Boolean

    val data: Map<String, List<Any?>>

    val added: Map<String, List<Any?>>

    val deleted: Map<String, List<Any?>>

    val changed: Map<String, List<Any?>>

    val typing: Map<String, ColumnType>

    fun update()

    fun listen(listener: () -> Unit)

    fun progress(listener: () -> Unit)

    fun transformed()

    fun getFirst(): Any

    fun setAll(value: Any)

    fun select(columns: Set<String>, start: Int, end: Int): RoutingContext

    fun recycle()
}