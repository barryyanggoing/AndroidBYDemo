package com.barryyang.barryyangdemo.android.demo.ifelse

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.barryyang.barryyangdemo.R
import com.barryyang.barryyangdemo.android.demo.ifelse.pay.IPay
import com.barryyang.barryyangdemo.android.demo.ifelse.pay.PayService

/**
 * @author : BarryYang
 * @date : 1/20/21 6:39 PM
 * @desc :if else 优化
 */
class IfElseActivity : AppCompatActivity() {

    private lateinit var mPayService: PayService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        mPayService = PayService()
    }

    /**
     * 微信支付
     */
    fun wxpay(view: View) {
        mPayService.toPay(IPay.WX_PAY_CODE)
    }

    /**
     * 支付宝支付
     */
    fun alipay(view: View) {
        mPayService.toPay(IPay.ALIPAY_PAY_CODE)
    }

    /**
     * 京东支付
     */
    fun jdpay(view: View) {
        mPayService.toPay(IPay.JD_PAY_CODE)
    }

}