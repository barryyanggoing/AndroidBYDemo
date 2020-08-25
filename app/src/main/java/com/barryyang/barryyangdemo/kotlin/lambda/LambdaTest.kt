package com.barryyang.barryyangdemo.kotlin.lambda

/**
 * @author : BarryYang
 * @date : 2020/8/25 11:48 AM
 * @desc :
 *
 * 1. 无参数的情况 ：val/var 变量名 = { 操作的代码 }
 * 2. 有参数的情况val/var 变量名 : (参数的类型，参数类型，...) -> 返回值类型 = {参数1，参数2，... -> 操作参数的代码 }
 * 可等价于// 此种写法：即表达式的返回值类型会根据操作的代码自推导出来。val/var 变量名 = { 参数1 ： 类型，参数2 : 类型, ... -> 操作参数的代码 }
 * 3. lambda表达式作为函数中的参数的时候，这里举一个例子：fun test(a : Int, 参数名 : (参数1 ： 类型，参数2 : 类型, ... ) -> 表达式返回类型){ ... }
 *
 */

//fun test(){
//    println("无参数")
//}

//val test = {
//    println("无参数")
//}

//fun test(a: Int, b: Int): Int {
//    return a + b
//}

//val test: (Int, Int) -> Int = { a, b -> a + b }

val test = { a: Int, b: Int -> a + b }

fun main() {
    val result = test(1, 2)
    println("${result}")
}