package com.barryyang.barryyangdemo.kotlin.test

/**
 * @author : BarryYang
 * @date : 2020/8/19 6:28 PM
 * @desc :out修饰符称为型变注解，并且由于它在类型参数声明处提供，所以我们称之为声明处型变。
 */
interface Source<out T> {
    fun nextT(): T
}