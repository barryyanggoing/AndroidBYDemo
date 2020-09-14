package com.barryyang.barryyangdemo.kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barryyang.barryyangdemo.R
import java.util.*

/**
 * @author : BarryYang
 * @date : 2020/8/3 4:23 PM
 * @desc :kotlin的使用
 */
class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
    }

    fun jumpAdapter(view: View) {
        startActivity(Intent(this, KotlinAdapterActivity::class.java))
    }

    fun jumpCoroutine(view: View) {
        startActivity(Intent(this, KotlinCoroutineActivity::class.java))
    }

}