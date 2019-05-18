@file:Suppress("FunctionName")

package ca.warp7.rt.router.impl

import ca.warp7.rt.router.RoutingContext
import ca.warp7.rt.router.RoutingDelegate
import ca.warp7.rt.router.util.Column
import ca.warp7.rt.router.util.ColumnType
import ca.warp7.rt.router.util.ContextDescriptor
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

private val mutex = ReentrantLock()
private val azimuth: RoutingControl by lazy { Azimuth() }

private val types = ColumnType.values().map { it.name }

private val lexerRegex = "^[=?!%#@]".toRegex()

private inline fun mutexControl(action: RoutingControl.() -> List<ContextDescriptor>) =
    mutex.withLock { action(azimuth) }

private fun ColumnType.asColumn(): Column {
    return Column(name, this)
}

fun _byRoute(endpoints: List<Any>): List<ContextDescriptor> {
    assert(endpoints.isNotEmpty()) { "Cannot route to nothing" }
    val delegates = endpoints.mapNotNull { it as? RoutingDelegate }
    val contexts = endpoints.mapNotNull { it as? RoutingContext }.toMutableList()
    if (delegates.isNotEmpty()) {
        contexts.addAll(delegates.map {
            val routingAgent by it
            routingAgent
        })
    }
    val columnTypes = endpoints.mapNotNull { it as? ColumnType }
    val columns = endpoints.mapNotNull { it as? Column }.toMutableList()
    if (columnTypes.isNotEmpty()) columns.addAll(columnTypes.map { it.asColumn() })
    val strings = endpoints.mapNotNull {
        (it as? String)?.trim()
    }
    var forLexer = -1
    for ((i, s) in strings.withIndex()) {
        if (s.matches(lexerRegex)) {
            forLexer = i
            break
        } else if (s in types) {
            columns.add(ColumnType.valueOf(s).asColumn())
        }
    }
    return mutexControl {
        when {
            forLexer > -1 -> queryDescriptor(strings[forLexer])
            contexts.isNotEmpty() -> contextDescriptor(contexts, columns)
            columns.isNotEmpty() -> columnDescriptor(columns)
            else -> listOf()
        }
    }
}

fun _byRoute(endpoints: String): List<ContextDescriptor> {
    return if (endpoints.matches(lexerRegex)) {
        mutexControl {
            queryDescriptor(endpoints)
        }
    } else listOf()
}