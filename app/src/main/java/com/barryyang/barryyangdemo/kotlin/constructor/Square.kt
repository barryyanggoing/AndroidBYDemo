package com.barryyang.barryyangdemo.kotlin.constructor

/**
 * @author : BarryYang
 * @date : 2020/8/20 4:47 PM
 * @desc :
 */
class Square : Ractangle(), Polygon {

    override fun draw() {
        super<Polygon>.draw()
        super<Ractangle>.draw()
    }
}