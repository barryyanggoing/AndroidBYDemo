package com.barryyang.barryyangdemo.designmodel.zhongjiezhe

import com.barryyang.barryyangdemo.utils.LogUtil

/**
 * @author : BarryYang
 * @date : 2020/8/28 2:47 PM
 * @desc :库存
 */
class Stock(mediator: AbstractMediator) : AbstractColleague(mediator) {

    private val TAG = "Stock"

    companion object {
        private var COMPUTE_NUMBER = 100
    }

    fun increase(number: Int) {
        COMPUTE_NUMBER += number
        LogUtil.printLogDebug(TAG, "库存数量为${COMPUTE_NUMBER}台")
    }

    fun decrease(number: Int) {
        COMPUTE_NUMBER -= number
        LogUtil.printLogDebug(TAG, "库存数量为${COMPUTE_NUMBER}台")
    }

    fun getStockNumber() = COMPUTE_NUMBER

    fun clearStock() {
        super.mediator.execute("stock.clear")
    }
}