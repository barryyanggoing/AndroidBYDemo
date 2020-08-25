package com.barryyang.barryyangdemo.designmodel.builder

/**
 * @author : BarryYang
 * @date : 2020/8/25 3:50 PM
 * @desc :
 */
abstract class CarBuilder {

    abstract fun setSequence(sequence: ArrayList<String>)

    abstract fun getCarModel(): AbstractCarModel

}