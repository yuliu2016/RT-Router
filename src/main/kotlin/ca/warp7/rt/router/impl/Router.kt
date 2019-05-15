package ca.warp7.rt.router.impl

import ca.warp7.rt.router.util.ContextDescriptor

private val descriptors: List<ContextDescriptor> = listOf()

private var routingIndex = 0

fun routing0(endpoints: List<Any>): List<ContextDescriptor> {
    checkEndpointLength(endpoints)
    val descriptor0 = descriptors.subList(0, ++routingIndex)
    reportEndpointState(endpoints)
    return descriptor0
}

const val kLengthThreshold = 10

fun checkedVararg(v: List<Any>): List<Any> {
    if (v.size > kLengthThreshold) return listOf(v)
    return v
}

fun checkEndpointLength(endpoint: List<Any>) {
    if (endpoint.size > kLengthThreshold)
        reportHeadlessState(endpoint)
}

fun reportEndpointState(v: Any) {
    println(v)
}

fun reportHeadlessState(v: Any): Nothing {
    throw IllegalStateException("Unable to route into $v")
}