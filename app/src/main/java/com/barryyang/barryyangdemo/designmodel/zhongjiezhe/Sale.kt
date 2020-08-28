package com.barryyang.barryyangdemo.designmodel.zhongjiezhe

import com.barryyang.barryyangdemo.utils.LogUtil
import kotlin.random.Random

/**
 * @author : BarryYang
 * @date : 2020/8/28 2:45 PM
 * @desc :售卖
 */
class Sale(mediator: AbstractMediator) : AbstractColleague(mediator) {

    private val TAG = "Sale"

    fun sellIBMCompute(number: Int) {
        super.mediator.execute("sale.sell", number)
    }

    fun getSaleStatus(): Int {
        val random = Random(System.currentTimeMillis())
        val saleStatus = random.nextInt(100)
        LogUtil.printLogDebug(TAG, "销售IBM电脑销售情况为${saleStatus}台")
        return saleStatus
    }

    fun offSale() {
        super.mediator.execute("sale.offsell")
    }
}