package ca.warp7.rt.router.impl

import ca.warp7.rt.router.RoutingContext
import ca.warp7.rt.router.RoutingDelegate
import ca.warp7.rt.router.util.Column
import ca.warp7.rt.router.util.ColumnType
import ca.warp7.rt.router.util.ContextDescriptor
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

private val mutex = ReentrantLock()
private val control: RoutingControl = TODO()

private inline fun mutexControl(action: RoutingControl.() -> List<ContextDescriptor>): List<ContextDescriptor> {
    return mutex.withLock {
        action(control)
    }
}

private fun ColumnType.asColumn(): Column {
    return Column(name, this)
}

private fun String.forLexer(): Boolean {
    return startsWith("")
}

@Suppress("FunctionName")
fun _byRoute(endpoints: List<Any>): List<ContextDescriptor> {
    assert(endpoints.isNotEmpty()) {
        "Cannot route to nothing"
    }
    val delegates = endpoints.mapNotNull {
        it as? RoutingDelegate
    }
    val contexts = endpoints.mapNotNull {
        it as? RoutingContext
    }.toMutableList()
    if (delegates.isNotEmpty()) {
        contexts.addAll(delegates.map {
            val routingAgent by it
            routingAgent
        })
    }
    val strings = endpoints.mapNotNull {
        it as? String
    }
    var forLexer = -1
    for ((i, s) in strings.withIndex()) {
        if (s.forLexer()) {
            forLexer = i
            break
        }
    }
    val columnTypes = endpoints.mapNotNull {
        it as? ColumnType
    }
    val columns = endpoints.mapNotNull {
        it as? Column
    }.toMutableList()
    if (columnTypes.isNotEmpty()){
        columns.addAll(columnTypes.map {
            it.asColumn()
        })
    }
    val ranges = endpoints.mapNotNull {
        it as? IntRange
    }
    assert(ranges.size < 2) {
        "Cannot use more than 1 range"
    }
    return mutexControl {
        listOf()
    }
}