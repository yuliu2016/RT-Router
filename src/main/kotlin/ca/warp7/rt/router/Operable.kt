package ca.warp7.rt.router

interface Operable {
    operator fun times(x: Any): Operable
    operator fun div(x: Any): Operable
    operator fun plus(x: Any): Operable
    operator fun minus(x: Any): Operable
    operator fun rangeTo(x: Any): Operable
    operator fun get(vararg x: Any): Operable
    operator fun set(k: Any, v: Any): Operable
    operator fun compareTo(x: Any): Int
}