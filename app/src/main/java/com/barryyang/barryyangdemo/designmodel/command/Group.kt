package com.barryyang.barryyangdemo.designmodel.command

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:27 PM
 * @desc :
 */
abstract class Group {

    abstract fun find()
    abstract fun add()
    abstract fun delete()
    abstract fun change()
    abstract fun plan()
}