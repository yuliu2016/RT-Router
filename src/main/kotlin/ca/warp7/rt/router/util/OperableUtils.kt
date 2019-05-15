package ca.warp7.rt.router.util

import ca.warp7.rt.router.Operable

fun Operable.letString(f: Data<String>.() -> Any): Operable = TODO()
fun Operable.letInt(f: (Int) -> Any): Operable = letValue { f(it as Int) }
fun Operable.letDouble(f: (Double) -> Any): Operable = letValue { f(it as Double) }
fun Operable.letBoolean(f: (Boolean) -> Any): Operable = letValue { f(it as Boolean) }