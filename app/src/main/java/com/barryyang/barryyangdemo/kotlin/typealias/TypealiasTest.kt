package com.barryyang.barryyangdemo.kotlin.`typealias`

/**
 * @author : BarryYang
 * @date : 2020/9/15 4:45 PM
 * @desc :类型别名:为现有类型提供替代名称，如果类型名称太长，你可以另外引用较短的名称，并且使用新的名称替代原类型名
 */
typealias Block<T> = () -> T
typealias Error<T> = () -> T

fun main() {
    sum(1, 2, block = {
        println("类型别名")
    }, error = {

    })
}

fun sum(a: Int, b: Int, block: Block<Unit>, error: () -> Unit): Int {
    val r = a + b
    block.invoke()
    error.invoke()
    return r
}