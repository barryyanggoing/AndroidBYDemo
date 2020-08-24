package com.barryyang.barryyangdemo.designmodel.model

import com.barryyang.barryyangdemo.utils.LogUtil

/**
 * @author : BarryYang
 * @date : 2020/8/24 10:03 AM
 * @desc :
 */
class Car2 : AbstractCarModel() {

    companion object {
        private const val TAG = "Car2"
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