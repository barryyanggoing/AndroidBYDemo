package com.barryyang.barryyangdemo.designmodel.factory.abstract_factory

/**
 * @author : BarryYang
 * @date : 2020/8/22 4:34 PM
 * @desc :
 */
class MaleFactory : HumanFactory {

    override fun createWhiteHuman(): IHuman {
        return MaleWhiteHuman()
    }

}