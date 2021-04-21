package com.barryyang.barryyangdemo.designmodel.zerenlian

import com.barryyang.barryyangdemo.utils.LogUtil

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:54 PM
 * @desc :
 */
class Son : Handler() {

    override fun response(request: Request): Response? {
        LogUtil.printLogDebug("责任链儿子")
        return null
    }

    override fun nextHandler(): Handler? {
        return null
    }


}