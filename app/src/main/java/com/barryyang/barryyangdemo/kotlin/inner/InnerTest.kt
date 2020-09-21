package com.barryyang.barryyangdemo.kotlin.inner

/**
 * @author : BarryYang
 * @date : 2020/9/17 4:09 PM
 * @desc :嵌套类与内部类
 */
fun main() {
    val foo = Outer.Nested().foo()
    val foo1 = Outer().Inner().foo()
}
