package com.barryyang.barryyangdemo.kotlin.sealed

/**
 * @author : BarryYang
 * @date : 2020/8/18 6:21 PM
 * @desc :
 */
sealed class Shape {
    class Circle(val redius: Double) : Shape()
    class Rectangle(val width: Double, val height: Double) : Shape()
    class Triangle(val base: Double, val height: Double) : Shape()
}