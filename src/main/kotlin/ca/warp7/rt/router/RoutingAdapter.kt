package ca.warp7.rt.router

interface RoutingAdapter {
    fun letRowWise(f: Data<Map<String, Any>>.() -> Any): RoutingAdapter
    fun forEach(x: Any, f: () -> Unit): RoutingAdapter
    val data: Operable
    infix fun String.to(value: RoutingAdapter)
}