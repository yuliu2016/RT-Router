package ca.warp7.rt.router

data class ContextDescriptor(
    val contextName: String,
    val contextTokens: List<String>,
    val delegate: RoutingDelegate,
    val isDefined: Boolean
)