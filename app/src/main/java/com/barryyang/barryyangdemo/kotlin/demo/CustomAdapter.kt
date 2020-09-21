package com.barryyang.barryyangdemo.kotlin.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.barryyang.barryyangdemo.R
import com.barryyang.barryyangdemo.utils.LogUtil
import java.util.*

/**
 * @author : BarryYang
 * @date : 2020/8/3 4:34 PM
 * @desc :
 */
class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private val TAG: String = "CustomAdapter"

    private var list = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kotlin_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.tv_item)
    }

    /**
     * 它是将某对象作为函数的参数，在函数块内可以通过 this 指代该对象。
     * 适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可，经常用于Android中RecyclerView中onBinderViewHolder中，数据model的属性映射到UI上
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //方式一
        list[position].let { textname ->
            holder.textView.text = textname
        }

        //方式二
        with(list[position]) {
            holder.textView.text = this
        }

        //方式三
        list[position].run {
            holder.textView.text = this
        }

        holder.textView.setBackgroundResource(if (position % 2 == 0) R.color.colorPrimary else R.color.colorAccent)
        holder.itemView.setOnClickListener { viewItem ->
            LogUtil.printLogDebug(TAG, "点击item")
        }
    }

    fun setData(list: ArrayList<String>) {
        this.list = list
        notifyDataSetChanged()
    }
}