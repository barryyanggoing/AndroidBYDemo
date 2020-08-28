package com.barryyang.barryyangdemo.designmodel.command

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:33 PM
 * @desc :
 */
class Invoker {

    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun action() {
        this.command?.execute()
    }
}