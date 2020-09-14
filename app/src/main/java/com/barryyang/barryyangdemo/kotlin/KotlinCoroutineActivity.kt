package com.barryyang.barryyangdemo.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.barryyang.barryyangdemo.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * @author : BarryYang
 * @date : 2020/9/11 5:19 PM
 * @desc :协程
 */
class KotlinCoroutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        startLaunch()
    }

    fun startLaunch() {
        GlobalScope.launch {
            println(Thread.currentThread().name)
        }
    }
}