package com.barryyang.barryyangdemo.android.demo.ifelse.pay

import androidx.annotation.IntDef

/**
 * @author : BarryYang
 * @date : 1/20/21 8:26 PM
 * @desc :
 */
interface IPay {

    companion object {
        const val WX_PAY_CODE = 1
        const val ALIPAY_PAY_CODE = 2
        const val JD_PAY_CODE = 3
    }

    @IntDef(WX_PAY_CODE, ALIPAY_PAY_CODE, JD_PAY_CODE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    annotation class PayCode

    fun pay()
}