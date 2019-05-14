package ca.warp7.rt.router

fun RoutingAdapter.letString(f: (String) -> Any): RoutingAdapter = letValue { f(it as String) }
fun RoutingAdapter.letInt(f: (Int) -> Any): RoutingAdapter = letValue { f(it as Int) }
fun RoutingAdapter.letDouble(f: (Double) -> Any): RoutingAdapter = letValue { f(it as Double) }
fun RoutingAdapter.letBoolean(f: (Boolean) -> Any): RoutingAdapter = letValue { f(it as Boolean) }