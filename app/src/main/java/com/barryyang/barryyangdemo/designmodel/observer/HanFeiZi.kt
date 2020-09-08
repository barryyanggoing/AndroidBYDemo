package com.barryyang.barryyangdemo.designmodel.observer

/**
 * @author : BarryYang
 * @date : 2020/9/2 11:06 AM
 * @desc :
 */
class HanFeiZi : IHanFeiZi, Observable {

    private val observerList = mutableListOf<Observer>()

    override fun haveBreakfest() {
        notifyObserver("在吃饭")
    }

    override fun haveFun() {
        notifyObserver("在娱乐")
    }

    override fun addObserver(observer: Observer) {
        observerList.add(observer)
    }

    override fun deleteObserver(observer: Observer) {
        observerList.remove(observer)
    }

    override fun notifyObserver(content: String) {
        for (observer in observerList) {
            observer.update(content)
        }
    }
}