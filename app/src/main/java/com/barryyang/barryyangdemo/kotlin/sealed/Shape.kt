package com.barryyang.barryyangdemo.kotlin.sealed

/**
 * @author : BarryYang
 * @date : 2020/8/18 6:21 PM
 * @desc :
 *
 * ⼀个密封类是⾃⾝抽象的，它不能直接实例化并可以有抽象（abstract）成员。
 * 密封类不允许有⾮-private 构造函数（其构造函数默认为 private）。
 * 请注意，扩展密封类⼦类的类（间接继承者）可以放在任何位置，⽽⽆需在同⼀个⽂件中。
 * 使⽤密封类的关键好处在于使⽤ when 表达式 的时候，如果能够验证语句覆盖了所有情况，就不需要为该语句再添加 ⼀个 else ⼦句了。
 * 当然，这只有当你⽤ when 作为表达式（使⽤结果）⽽不是作为语句时才有⽤。
 */
sealed class Shape {
    class Circle(val redius: Double) : Shape()
    class Rectangle(val width: Double, val height: Double) : Shape()
    class Triangle(val base: Double, val height: Double) : Shape()
}