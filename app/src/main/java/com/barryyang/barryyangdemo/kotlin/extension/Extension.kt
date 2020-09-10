package com.barryyang.barryyangdemo.kotlin.extension

/**
 * @author : BarryYang
 * @date : 2020/9/10 10:10 AM
 * @desc :扩展函数
 */

/**
 * 扩展函数
 */
fun String.spaceToBarry() {
    "sss".spaceToBarry()
}

/**
 * Kotlin 能够扩展⼀个类的新功能⽽⽆需继承该类或者使⽤像装饰者这样的设计模式。这通过叫做 扩展 的特殊声明完成。
 * 例如，你可以为⼀个你不能修改的、来⾃第三⽅库中的类编写⼀个新的函数。这个新增的函数就像那个原始类本来就有的函数⼀样，可以⽤普通的⽅法调⽤。这种机制称为 扩展函数 。
 * 此外，也有 扩展属性 ，允许你为⼀个已经存在的类添加新的属性。
 */
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

/**
 * 如果⼀个类定义有⼀个成员函数与⼀个扩展函数，⽽这两个函数⼜有相同的接收者类型、相同的名字，并且都适⽤给 定的参数，这种情况总是取成员函数。
 */
fun Example.printFunctionType(i: Int) {
    println("kuozhan")
}

fun Any?.toString(): String {
    if (this == null) return "null"
    return toString()
}