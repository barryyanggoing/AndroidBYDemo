package com.barryyang.barryyangdemo.designmodel.zerenlian

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:51 PM
 * @desc :
 */
interface IWomen {

    /**
     * 获得个人状况
     */
    fun getType(): Int

    /**
     *获得个人请示你要出去干什么
     */
    fun getRequest():String
}