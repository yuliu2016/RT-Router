package ca.warp7.rt.router.impl

import ca.warp7.rt.router.ContextDescriptor
import ca.warp7.rt.router.RoutingDelegate

private val delegates: List<RoutingDelegate> = listOf()

private var routingIndex = 0
private var endpoints: MutableList<Pair<Any, RoutingDelegate>> = mutableListOf()

fun routing0(endpoint: List<Any>): List<ContextDescriptor> {
    endpoints.forEach {
        if (it.first === endpoint) return listOf()
    }
    val delegate = delegates[++routingIndex]
    endpoints.add(endpoint to delegate)
    return listOf()
}

const val kLengthThreshold = 10

fun checkedVararg(v: List<Any>): List<Any> {
    if (v.size > kLengthThreshold) return listOf(v)
    return v
}