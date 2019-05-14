package ca.warp7.rt.router

// replaces Context

interface RoutingContext {

    val name: String

    val isDefined: Boolean

    val isEager: Boolean

    val hasNewData: Boolean

    fun updateData()

    fun listenForNewData(listener: () -> Unit)

    val lastData: Map<String, List<Any>>

    val lastAdded: Map<String, List<Any?>>

    val lastDeleted: Map<String, List<Any?>>

    val lastChanged: Map<String, List<Any?>>
}