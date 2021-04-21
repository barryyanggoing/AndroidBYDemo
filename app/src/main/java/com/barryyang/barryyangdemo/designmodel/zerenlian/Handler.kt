package com.barryyang.barryyangdemo.designmodel.zerenlian

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:53 PM
 * @desc :
 */
abstract class Handler {

    private var nextHandler: Handler? = null

    fun handlerMessage(request: Request): Response? {
        val response = response(request)
        if (response == null) {
            nextHandler?.handlerMessage(request)
        }
        return response
    }

    fun setNext(handler: Handler) {
        this.nextHandler = handler
    }

    fun getHandler(): Handler? {
        return nextHandler
    }

    abstract fun response(request: Request): Response?

    abstract fun nextHandler(): Handler?
}