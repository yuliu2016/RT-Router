package ca.warp7.rt.router.impl

import ca.warp7.rt.router.RoutingContext
import ca.warp7.rt.router.util.Column
import ca.warp7.rt.router.util.ContextDescriptor

class Azimuth: RoutingControl {
    override fun queryDescriptor(s: String): List<ContextDescriptor> {
        TODO("not implemented")
    }

    override fun contextDescriptor(contexts: List<RoutingContext>, columns: List<Column>): List<ContextDescriptor> {
        TODO("not implemented")
    }

    override fun columnDescriptor(columns: List<Column>): List<ContextDescriptor> {
        TODO("not implemented")
    }
}