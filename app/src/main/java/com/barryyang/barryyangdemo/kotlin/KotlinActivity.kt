package com.barryyang.barryyangdemo.kotlin

import android.os.Bundle
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

    /**
     * lateinit：延迟初始化，即他可以不用再对象初始化的时候就必须有值
     *
     * 即KotlinActivity创建的时候它不必一定有值
     */
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        showAdapter()
    }

    private fun showAdapter() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_list)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        customAdapter = CustomAdapter()
        recyclerView.adapter = customAdapter
        val list = ArrayList<String>()
        for (i in 0..100) {
            list.add(i.toString())
        }
        customAdapter.setData(list)
    }

}