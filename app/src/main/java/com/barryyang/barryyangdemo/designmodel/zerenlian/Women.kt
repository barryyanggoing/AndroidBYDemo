package com.barryyang.barryyangdemo.designmodel.zerenlian

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:58 PM
 * @desc :
 */
class Women(private val type: Int, private val request: String) : IWomen {

    override fun getType(): Int {
        return type
    }

    override fun getRequest(): String {
        return request
    }

}