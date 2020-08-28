package com.barryyang.barryyangdemo.designmodel.zhongjiezhe

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:04 PM
 * @desc :
 */
class Purchase(mediator: AbstractMediator) : AbstractColleague(mediator) {

    fun buyIBMCompute(number: Int) {
        super.mediator.execute("purchase.buy",number)
    }

    fun refuseBuyIBM() {
        //不再购买电脑
    }

}