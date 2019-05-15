package ca.warp7.rt.router.util

import ca.warp7.rt.router.RoutingDelegate

data class ContextDescriptor(
    val contextName: String,
    val contextTokens: List<String>,
    val delegate: RoutingDelegate,
    val isDefined: Boolean
)