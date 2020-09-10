package com.barryyang.barryyangdemo.android.motionlayout

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.barryyang.barryyangdemo.R

/**
 * @author : BarryYang
 * @date : 2020/8/27 3:20 PM
 * @desc :
 */
class MotionLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motionlayout)
    }

    fun basicMotion(view: View) {
        startActivity(Intent(this, BasicMotionLayoutActivity::class.java))
    }

    fun imageMotion(view: View) {
        startActivity(Intent(this, ImageFilterViewActivity::class.java))
    }
}

