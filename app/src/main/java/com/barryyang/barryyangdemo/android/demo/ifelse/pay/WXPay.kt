package com.barryyang.barryyangdemo.android.demo.ifelse.pay

import com.barryyang.barryyangdemo.android.demo.ifelse.pay.IPay

/**
 * @author : BarryYang
 * @date : 1/20/21 8:28 PM
 * @desc :
 */
class WXPay : IPay {

    override fun pay() {
        System.out.println("微信支付")
    }
}