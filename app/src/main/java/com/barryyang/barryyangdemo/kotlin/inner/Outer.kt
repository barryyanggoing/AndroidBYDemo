package com.barryyang.barryyangdemo.kotlin.inner

/**
 * @author : BarryYang
 * @date : 2020/9/15 5:14 PM
 * @desc :嵌套类和内部类
 */
class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }

    /**
     * 内部类会带有一个对外部类的引用
     */
    inner class Inner {
        fun foo() = bar
    }
}