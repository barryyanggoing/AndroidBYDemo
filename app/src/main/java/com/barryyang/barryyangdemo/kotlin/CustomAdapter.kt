package com.barryyang.barryyangdemo.kotlin

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

    private val TAG = "CustomAdapter"

    private var list = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kotlin_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = list[position]
        holder.textView.setBackgroundResource(if (position % 2 == 0) R.color.colorPrimary else R.color.colorAccent)
        holder.itemView.setOnClickListener(View.OnClickListener {
            LogUtil.printLogDebug(TAG, "点击item")
        })
    }

    fun setData(list: ArrayList<String>) {
        this.list = list
        notifyDataSetChanged()
    }
}