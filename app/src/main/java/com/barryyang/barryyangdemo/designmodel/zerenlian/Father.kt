package com.barryyang.barryyangdemo.designmodel.zerenlian

import com.barryyang.barryyangdemo.utils.LogUtil

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:54 PM
 * @desc :
 */
class Father : Handler() {

    override fun response(request: Request): Response? {
        LogUtil.printLogDebug("责任链爸爸")
        return Response()
    }

    override fun nextHandler(): Handler? {
        return Mother()
    }

}