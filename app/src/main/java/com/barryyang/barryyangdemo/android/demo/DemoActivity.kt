package com.barryyang.barryyangdemo.android.demo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.barryyang.barryyangdemo.R
import com.barryyang.barryyangdemo.main.JumpUtils
import com.barryyang.barryyangdemo.main.PublishType

/**
 * @author : BarryYang
 * @date : 1/20/21 6:33 PM
 * @desc :
 */
class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
    }

    /**
     * 优化if else
     */
    fun optimizeIfElse(view: View) {
        JumpUtils.getInstance().jump(this, PublishType.PT_IF_ELSE)
    }

}