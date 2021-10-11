package com.barryyang.barryyangdemo.kotlin.demo

/**
 * @author : BarryYang
 * @date : 2021/9/1 2:35 下午
 * @desc :
 */
interface Source<out T> {

    fun nextT(): T
}