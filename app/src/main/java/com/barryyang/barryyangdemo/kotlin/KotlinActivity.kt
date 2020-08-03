package com.barryyang.barryyangdemo.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barryyang.barryyangdemo.R
import com.barryyang.barryyangdemo.utils.LogUtil
import java.util.*

/**
 * @author : BarryYang
 * @date : 2020/8/3 4:23 PM
 * @desc :kotlin的使用
 */
class KotlinActivity : AppCompatActivity() {

    private val TAG = "KotlinActivity"

    /**
     * 可以更改变量的值
     */
    var language: String = "Kotlin"

    /**
     * 不可更改变量的值，相当于Java的常量final
     */
    val salary: Int = 10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        showAdapter()
        kotlinDemo()
        toLong()
        toInt()
    }

    private fun toInt() {
        val i: Long = 1000
        val j: Int = i.toInt()
        LogUtil.printLogDebug(TAG, "Long转成Int：$j")
    }

    private fun toLong() {
        val i = 1000
        val j: Long = i.toLong()
        LogUtil.printLogDebug(TAG, "Int转成Long：$j")
    }

    private fun kotlinDemo() {
        val arrayOf = arrayOf(1, 2, 3, 4, 5)
        val firstId = arrayOf[0]
        val i = arrayOf[arrayOf.size - 1]
        val array = Array(5, { i -> i * 2 })
        LogUtil.printLogDebug(TAG, "数组第一个元素：$firstId")
    }

    private fun showAdapter() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_list)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        val customAdapter = CustomAdapter()
        recyclerView.adapter = customAdapter
        val list = ArrayList<String>()
        for (i in 0..100) {
            list.add(i.toString())
        }
        customAdapter.setData(list)
    }

}