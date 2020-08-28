package com.barryyang.barryyangdemo.designmodel.zhongjiezhe

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:15 PM
 * @desc :
 */
abstract class AbstractMediator {

    protected val purchase: Purchase = Purchase(this)
    protected val stock: Stock = Stock(this)
    protected val sale: Sale = Sale(this)

    abstract fun execute(str: String?, vararg objects: Any?)

}