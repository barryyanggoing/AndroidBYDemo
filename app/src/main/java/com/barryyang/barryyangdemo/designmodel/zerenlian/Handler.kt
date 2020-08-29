package com.barryyang.barryyangdemo.designmodel.zerenlian

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:53 PM
 * @desc :
 */
abstract class Handler() {

    private var nextHandler: Handler? = null

    fun handlerMessage(request: Request): Response? {
        return if (getHandlerLevel() == request.getRequestLevel())
            response(request)
        else {
            nextHandler?.handlerMessage(request)
        }
    }

    fun setNext(handler: Handler) {
        this.nextHandler = handler
    }

    abstract fun response(request: Request): Response

    abstract fun getHandlerLevel(): Level
}