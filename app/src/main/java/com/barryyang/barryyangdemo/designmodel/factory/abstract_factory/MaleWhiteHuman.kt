package com.barryyang.barryyangdemo.designmodel.factory.abstract_factory

import com.barryyang.barryyangdemo.utils.LogUtil

/**
 * @author : BarryYang
 * @date : 2020/8/22 4:29 PM
 * @desc :
 */
class MaleWhiteHuman : AbstractWhiteHuman() {

    companion object {
        private const val TAG = "MaleWhiteHuman"
    }

    override fun getSex() {
        print("男性白种人白色")
        LogUtil.printLogDebug(TAG, "男性白种人白色")
    }

}