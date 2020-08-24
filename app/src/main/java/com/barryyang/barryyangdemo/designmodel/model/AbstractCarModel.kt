package com.barryyang.barryyangdemo.designmodel.model

/**
 * @author : BarryYang
 * @date : 2020/8/24 9:51 AM
 * @desc :多个子类有公有的方法，并且逻辑基本相同时
 */
abstract class AbstractCarModel {

    abstract fun start()

    abstract fun stop()

    abstract fun engineBottom()

    abstract fun alarm()

    fun run() {
        this.start()
        this.engineBottom()
        this.alarm()
        this.stop()
    }

}