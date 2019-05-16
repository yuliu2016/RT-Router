package ca.warp7.rt.router

import ca.warp7.rt.router.util.ColumnType

// replaces Context

interface RoutingContext {

    val name: String

    val isActive: Boolean

    val isDefined: Boolean

    val hasNewData: Boolean

    val typing: Map<String, ColumnType>

    val data: Map<String, List<Any?>>

    fun update()

    fun listen(listener: () -> Unit)

    fun recycle()
}