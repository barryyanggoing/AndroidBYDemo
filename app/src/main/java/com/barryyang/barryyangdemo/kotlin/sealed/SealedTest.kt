package com.barryyang.barryyangdemo.kotlin.sealed

/**
 * @author : BarryYang
 * @date : 2020/9/10 10:08 AM
 * @desc :密封函数测试
 */

/**
 * 密封类
 */
fun testSealed(sealed: Shape) {
    val x = when (sealed) {
        is Shape.Circle -> sealed.redius
        is Shape.Rectangle -> sealed.height
        is Shape.Triangle -> sealed.base
    }
}