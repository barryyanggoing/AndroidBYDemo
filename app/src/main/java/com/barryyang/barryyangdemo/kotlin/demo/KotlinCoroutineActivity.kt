package com.barryyang.barryyangdemo.kotlin.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
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
        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginViewModel.login("barryyang","123456")
    }

}