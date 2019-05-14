package ca.warp7.rt.router

import kotlin.properties.ReadOnlyProperty

// replaces ContextLoader and RootLoader

interface RoutingDelegate : ReadOnlyProperty<Any?, RoutingContext> {
    val routes: List<RoutingContext>
    val properties: RTProperties
}