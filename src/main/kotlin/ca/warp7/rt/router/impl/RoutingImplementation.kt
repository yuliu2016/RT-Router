package ca.warp7.rt.router.impl

import ca.warp7.rt.router.ContextDescriptor

private val descriptors: List<ContextDescriptor> = listOf()

private var routingIndex = 0

fun routing0(endpoint: List<Any>): List<ContextDescriptor> {
    val descriptor0 = descriptors.subList(0, ++routingIndex)
    reportEndpointState(endpoint)
    return descriptor0
}

const val kLengthThreshold = 10

fun checkedVararg(v: List<Any>): List<Any> {
    if (v.size > kLengthThreshold) return listOf(v)
    return v
}

fun reportEndpointState(v: Any) {
    println(v)
}

fun reportHeadlessState(v: Any): Nothing {
    throw IllegalStateException("Unable to route into $v")
}