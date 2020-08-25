package com.barryyang.barryyangdemo.designmodel.builder

/**
 * @author : BarryYang
 * @date : 2020/8/25 3:52 PM
 * @desc :
 */
class BwmCarBuilder : CarBuilder() {

    private val bmwModel = BmwModel()

    override fun setSequence(sequence: ArrayList<String>) {
        this.bmwModel.setSequence(sequence)
    }

    override fun getCarModel(): AbstractCarModel = bmwModel
}