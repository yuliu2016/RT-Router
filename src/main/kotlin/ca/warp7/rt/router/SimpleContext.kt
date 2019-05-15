package ca.warp7.rt.router

interface SimpleContext {
    val actualContext: RoutingContext
    var data: MutableMap<String, List<Any?>>
    var typing: MutableMap<String, ColumnType>
    fun notifyDataChanged()
}