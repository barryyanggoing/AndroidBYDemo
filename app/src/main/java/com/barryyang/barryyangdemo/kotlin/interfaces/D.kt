package com.barryyang.barryyangdemo.kotlin.interfaces

/**
 * @author : BarryYang
 * @date : 2020/8/21 3:37 PM
 * @desc :
 */
class D : A, B {

    override fun a() {
        super<A>.a()
        super<B>.a()
    }

    override fun b() {
        super<B>.b()
    }

}