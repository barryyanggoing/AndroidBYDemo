package com.barryyang.barryyangdemo.designmodel.builder

/**
 * @author : BarryYang
 * @date : 2020/8/25 3:52 PM
 * @desc :
 */
class BenzCarBuilder : CarBuilder() {

    private val benzModel = BenzModel()

    override fun setSequence(sequence: ArrayList<String>) {
        this.benzModel.setSequence(sequence)
    }

    override fun getCarModel(): AbstractCarModel = benzModel
}