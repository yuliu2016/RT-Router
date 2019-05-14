package ca.warp7.rt.router

interface RoutingAdapter {
    operator fun times(x: Any): RoutingAdapter
    operator fun div(x: Any): RoutingAdapter
    operator fun plus(x: Any): RoutingAdapter
    operator fun minus(x: Any): RoutingAdapter
    operator fun rangeTo(x: Any): RoutingAdapter
    operator fun get(x: Any): RoutingAdapter
    operator fun set(k: Any, v: Any): RoutingAdapter
    operator fun compareTo(x: Any): Int
    fun letValue(f: (Any) -> Any): RoutingAdapter
    fun forEach(x: Any, f: () -> Unit): RoutingAdapter
}