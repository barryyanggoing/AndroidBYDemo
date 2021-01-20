package com.barryyang.barryyangdemo.android.demo.ifelse.pay

/**
 * @author : BarryYang
 * @date : 1/20/21 8:35 PM
 * @desc :
 */
class PayService {

    private var mJDPay: JDPay
    private var mAliPay: AliPay
    private var mWxPay: WXPay

    init {
        mAliPay = AliPay()
        mJDPay = JDPay()
        mWxPay = WXPay()
    }

    fun toPay(@IPay.PayCode code: Int) {
        when (code) {
            IPay.WX_PAY_CODE -> mWxPay.pay()
            IPay.ALIPAY_PAY_CODE -> mAliPay.pay()
            IPay.JD_PAY_CODE -> mJDPay.pay()
        }
    }
}