package com.barryyang.barryyangdemo.kotlin.generic

/**
 * @author : BarryYang
 * @date : 2020/8/19 10:08 AM
 * @desc :
 */
class SmartList<T> : ArrayList<T>() {

    fun find(t: T): T? {
        val indexOf = super.indexOf(t)
        return if (indexOf >= 0) super.get(indexOf) else null
    }

    /**
     * 使用扩展函数
     */
    fun <T> ArrayList<T>.find(t: T): T? {
        val indexOf = this.indexOf(t)
        return if (indexOf >= 0) this[indexOf] else null
    }
}

