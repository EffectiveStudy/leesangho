package com.github.sangholee.dev.effectivejavastudy.study05_item28

class GenericTypeErasureKotlin {
//    fun <T> isA(value: Any) = value is T
    inline fun <reified T> isA(value: Any) = value is T
}
