package com.barryyang.barryyangdemo.designmodel.observer

import com.barryyang.barryyangdemo.utils.LogUtil

/**
 * @author : BarryYang
 * @date : 2020/9/2 11:10 AM
 * @desc :
 */
class LiSi : Observer {

    private val TAG = "LiSi"

    override fun update(content: String) {
        LogUtil.printLogDebug(TAG, "lisi收到：${content}")
    }
}