package com.barryyang.barryyangdemo.designmodel.command

import com.barryyang.barryyangdemo.utils.LogUtil

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:28 PM
 * @desc :
 */
class PageGroup : Group() {

    private val TAG = "PageGroup"

    override fun find() {
        LogUtil.printLogDebug(TAG, "找打页面组")
    }

    override fun add() {
        TODO("Not yet implemented")
    }

    override fun delete() {
        LogUtil.printLogDebug(TAG, "删除相关页面")
    }

    override fun change() {
        TODO("Not yet implemented")
    }

    override fun plan() {
        LogUtil.printLogDebug(TAG, "执行命令")
    }
}