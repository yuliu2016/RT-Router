package ca.warp7.rt.router

import kotlin.properties.ReadOnlyProperty

interface RoutingDelegate : ReadOnlyProperty<Any?, RoutingContext>,
        (RoutingAdapter.() -> Unit) -> ReadOnlyProperty<Any?, RoutingContext>