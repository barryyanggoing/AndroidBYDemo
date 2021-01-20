package com.barryyang.barryyangdemo.android.demo.ifelse.pay

import com.barryyang.barryyangdemo.android.demo.ifelse.pay.IPay

/**
 * @author : BarryYang
 * @date : 1/20/21 8:27 PM
 * @desc :
 */
class AliPay : IPay {

    override fun pay() {
        System.out.println("阿里支付")
    }
}