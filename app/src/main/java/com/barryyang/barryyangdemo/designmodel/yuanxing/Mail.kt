package com.barryyang.barryyangdemo.designmodel.yuanxing

/**
 * @author : BarryYang
 * @date : 2020/8/26 10:25 AM
 * @desc :
 */
data class Mail(var receiver: String = "", var appellation: String = "", var tail: String = "aaaaaa") : Cloneable {

    private lateinit var subject: String
    private lateinit var content: String

    constructor(advTemplate: AdvTemplate) : this() {
        this.subject = advTemplate.advSubject
        this.content = advTemplate.advContent
    }

    public override fun clone(): Mail {
        return super.clone() as Mail
    }

}