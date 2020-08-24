package com.barryyang.barryyangdemo.designmodel.model

import com.barryyang.barryyangdemo.utils.LogUtil

/**
 * @author : BarryYang
 * @date : 2020/8/24 9:54 AM
 * @desc :模板设计模式
 */
class Car1 : AbstractCarModel() {

    companion object {
        private const val TAG = "Car1"
    }

    override fun start() {
        LogUtil.printLogDebug(TAG, "start()")
    }

    override fun stop() {
        LogUtil.printLogDebug(TAG, "stop()")
    }

    override fun engineBottom() {
        LogUtil.printLogDebug(TAG, "engineBottom()")
    }

    override fun alarm() {
        LogUtil.printLogDebug(TAG, "alarm()")
    }

}