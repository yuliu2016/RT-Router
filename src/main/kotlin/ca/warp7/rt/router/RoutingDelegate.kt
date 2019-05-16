package ca.warp7.rt.router

import ca.warp7.rt.router.util.DelegateOf

interface RoutingDelegate : DelegateOf<RoutingContext>,
        (RoutingAdapter.() -> Unit) -> DelegateOf<RoutingContext>