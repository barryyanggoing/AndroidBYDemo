package com.barryyang.barryyangdemo.kotlin.test

import com.barryyang.barryyangdemo.kotlin.generic.Apple
import com.barryyang.barryyangdemo.kotlin.generic.Banana
import com.barryyang.barryyangdemo.kotlin.generic.FruitPlate
import com.barryyang.barryyangdemo.kotlin.generic.SmartList
import com.barryyang.barryyangdemo.kotlin.lambda.Student
import com.google.gson.Gson
import java.io.File
import java.lang.NullPointerException

/**
 * @author : BarryYang
 * @date : 2020/8/19 10:15 AM
 * @desc :kotlin demo 测试
 */

fun main() {
//    testSmartList()
//    testFruit()
//    printDefault()
//    lambdaTest()
//    test1()
//    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
//    for ((k, v) in map) {
//        println("key和value的值：${k},${v}")
//    }
//    applyTest()
    // alsoTest()
//    breakTest()
    returnTest()
}

fun lambdaTest() {
    // val sum: Int.(Int) -> Int = { other -> plus(other) }
    val jilen = Student("Jilen", 30, "m", 85)
    val shaw = Student("Shaw", 18, "f", 90)
    val jack = Student("Jack", 40, "m", 59)
    val lisa = Student("Lisa", 25, "f", 70)
    val pan = Student("Pan", 36, "f", 88)
    val students = listOf(jilen, shaw, jack, lisa, pan)
    students.filter { it.sex == "m" }
            .forEach {
                println("${it.name}")
            }
    val totalScore = students.sumBy { it.score }
    println("总分：${totalScore}")

    val groupBySex = groupBySex(students)
    val get = groupBySex.get("m")
    get?.forEach {
        println("${it.name}")
    }

    students.groupBy { it.sex }
            .forEach() {
                it.value.forEach {
                    println("${it.name}")
                }
            }
}

/**
 * 有默认值的时候,方法可不传值
 */
private fun printDefault(name: String = "BarryYang"): String {
    println("姓名：${name}")
    return name
}

private fun testFruit() {
    val fruitPlate = FruitPlate(Apple(100.0))
    val fruitPlate1 = FruitPlate(Banana(100.0))
    val fruitPlate2 = FruitPlate(null)
}

private fun testSmartList() {
    val smartList = SmartList<String>()
    smartList.add("one")
    println(smartList.find("one"))
    println(smartList.find("two"))
}

/**
 * 内联函数，扩展函数
 */
inline fun <reified T : Any> Gson.fromJson(json: String): T {
    return Gson().fromJson(json, T::class.java)
}

/**
 * groupBy
 */
fun groupBySex(students: List<Student>): Map<String, List<Student>> {
    val mstudents = ArrayList<Student>()
    val mstudentsp = ArrayList<Student>()
    for (student in students) {
        if (student.sex == "m") {
            mstudents.add(student)
        } else {
            mstudentsp.add(student)
        }
    }
    return mapOf("m" to mstudents, "f" to mstudentsp)
}

fun isOdd(x: Int) = x % 2 != 0

/**
 * 集合filter
 */
private fun test1() {
    val listOf = listOf(1, 2, 3)
    listOf.filter(::isOdd)
            .forEach {
                println("函数引用：${it}")
            }

    val listofStr = listOf("d", "s")
    listofStr.filter { it == "s" }
    //.forEach()
}

/**
 * out
 */
private fun demo(str: Source<String>) {
    val objects: Source<Any> = str
}

/**
 * 空判断
 */
private fun nulltest() {
    val listFiles = File("Test").listFiles()
    print(listFiles?.size ?: throw NullPointerException())
}

/**
 * 当有默认值的时候方法可以这么调用foo(1)，后面的参数可以省略，但是前面的不能省略
 */
private fun foo(a: Int = 0, b: String = "") {

}

/**
 * 扩展函数
 */
fun String.spaceToBarry() {
    "sss".spaceToBarry()
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
 * let和with的结合
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

fun breakTest() {
    loop@ for (i in 1..100) {
        for (j in 1..10) {
            println("break测试:${j}")
            if (j == 10) break@loop
        }
    }
}

fun returnTest() {
    listOf(1, 2, 3, 4, 5).forEach {
        println(it)
        if (it == 3) return@forEach
    }
    println("return end")
}