package com.barryyang.barryyangdemo.designmodel.observer

/**
 * @author : BarryYang
 * @date : 2020/9/2 11:03 AM
 * @desc :被观察者
 */
interface Observable {

    fun addObserver(observer: Observer)
    fun deleteObserver(observer: Observer)
    fun notifyObserver(content: String)
}