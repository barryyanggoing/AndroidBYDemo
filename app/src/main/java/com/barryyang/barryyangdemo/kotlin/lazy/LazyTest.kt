package com.barryyang.barryyangdemo.kotlin.lazy

/**
 * @author : BarryYang
 * @date : 2020/9/17 5:03 PM
 * @desc :
 */
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

fun main(args: Array<String>) {
    println("第一次调用的时候会执行lazy里面的代码并且拿到lazyValue：${lazyValue}")
    println("第一次之后直接使用lazyValue的值：${lazyValue}")
}
