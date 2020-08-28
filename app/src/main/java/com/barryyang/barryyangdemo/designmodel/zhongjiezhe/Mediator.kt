package com.barryyang.barryyangdemo.designmodel.zhongjiezhe

/**
 * @author : BarryYang
 * @date : 2020/8/28 2:42 PM
 * @desc :
 */
class Mediator : AbstractMediator() {

    override fun execute(str: String?, vararg objects: Any?) {
        when (str) {
            "purchase.buy" -> this.buyComputer(objects[0] as Int)
            "sale.sell" -> this.sellComputer(objects[0] as Int)
            "sale.offsell" -> this.offsell()
            "stock.clear" -> this.clearStock()
        }
    }

    private fun clearStock(){
        super.sale.offSale()
        super.purchase.refuseBuyIBM()
    }

    private fun offsell() {
        stock.getStockNumber()
    }

    private fun sellComputer(number: Int) {
        val stockNumber = super.stock.getStockNumber()
        if (stockNumber < number) {
            super.purchase.buyIBMCompute(number)
        }
        super.stock.decrease(number)
    }

    private fun buyComputer(number: Int) {
        val saleStatus = super.sale.getSaleStatus()
        if (saleStatus > 80) {
            super.stock.increase(number)
        } else {
            super.stock.increase(number / 2)
        }
    }
}