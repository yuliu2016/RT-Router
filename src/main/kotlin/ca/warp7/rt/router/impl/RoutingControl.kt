package ca.warp7.rt.router.impl

import ca.warp7.rt.router.RoutingContext
import ca.warp7.rt.router.util.Column
import ca.warp7.rt.router.util.ContextDescriptor

interface RoutingControl {
    fun queryDescriptor(s: String): List<ContextDescriptor>
    fun contextDescriptor(contexts: List<RoutingContext>, columns: List<Column>): List<ContextDescriptor>
    fun columnDescriptor(columns: List<Column>): List<ContextDescriptor>
}