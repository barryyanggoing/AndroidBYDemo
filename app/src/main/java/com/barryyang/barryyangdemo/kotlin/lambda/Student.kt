package com.barryyang.barryyangdemo.kotlin.lambda

/**
 * @author : BarryYang
 * @date : 2020/8/19 3:39 PM
 * @desc :
 */
data class Student(val name: String, val age: Int, val sex: String, val score: Int) {

    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
        println("First initializer block that prints ${firstProperty}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
        println("First initializer block that prints ${secondProperty}")
    }
}