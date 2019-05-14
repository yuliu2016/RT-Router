package ca.warp7.rt.router.impl

import ca.warp7.rt.router.RoutingDelegate

private val delegates: List<RoutingDelegate> = listOf()

private val azimuth = Azimuth()

private var routingIndex = 0
private var endpoints: MutableList<Pair<Any, RoutingDelegate>> = mutableListOf()

fun routing0(endpoint: List<Any>): RoutingDelegate {
    endpoints.forEach {
        if (it.first === endpoint) return it.second
    }
    azimuth
    val delegate = delegates[++routingIndex]
    endpoints.add(endpoint to delegate)
    return delegate
}

class Azimuth {

}