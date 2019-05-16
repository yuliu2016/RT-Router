package ca.warp7.rt.router.impl

import ca.warp7.rt.router.util.ContextDescriptor

private val descriptors: List<ContextDescriptor> = listOf()

private var routingIndex = 0

@Suppress("FunctionName")
fun _byRoute(endpoints: List<Any>): List<ContextDescriptor> {
    val descriptor0 = descriptors.subList(0, ++routingIndex)
    println(endpoints)
    return descriptor0
}