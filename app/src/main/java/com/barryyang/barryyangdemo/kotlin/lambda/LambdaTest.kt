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

/**
 * let扩展函数的实际上是一个作用域函数，当你需要去定义一个变量在一个特定的作用域范围内，let函数的是一个不错的选择；
 * let函数另一个作用就是可以避免写一些判断null的操作。
 */
fun letTest() {
    val student = Student("BarryYang", 30, "m", 100)
    student.let {
        println("学生的信息：${student.name}")
    }
}

/**
 * 它是将某对象作为函数的参数，在函数块内可以通过 this 指代该对象。
 * 适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可，经常用于Android中RecyclerView中onBinderViewHolder中，数据model的属性映射到UI上
 */
fun withTest() {
    val student = Student("BarryYang", 30, "m", 100)
    with(student) {
        println("学生的信息：${name}")
    }
}

/**
 * let和with的结合 run函数是以闭包形式返回最后一行代码的值
 */
fun runTest() {
    val student = Student("BarryYang", 30, "m", 100)
    student.run {
        println("学生的信息：${name}")
    }
}

/**
 * run函数是以闭包形式返回最后一行代码的值，而apply函数的返回的是传入对象的本身。
 *
 * apply一般用于一个对象实例初始化的时候，需要对对象中的属性进行赋值。或者动态inflate出一个XML的View的时候需要给View绑定数据也会用到
 */
fun applyTest() {
    val student = Student("BarryYang", 30, "m", 100)
    val result = student.apply {
        println("学生的信息：${name}")
    }
    println("result信息：${result}")
}

/**
 * also函数的结构实际上和let很像唯一的区别就是返回值的不一样，let是以闭包的形式返回，返回函数体内最后一行的值，
 * 如果最后一行为空就返回一个Unit类型的默认值。而also函数返回的则是传入对象的本身
 */
fun alsoTest() {
    var a = 1
    var b = 2
    a = b.also {
        b = a
    }
    println("a,b的值为${a},${b}")
}