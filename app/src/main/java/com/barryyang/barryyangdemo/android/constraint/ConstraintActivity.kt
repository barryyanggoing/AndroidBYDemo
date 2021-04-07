package com.barryyang.barryyangdemo.android.constraint

import android.os.Bundle
import android.view.View.generateViewId
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.helper.widget.Layer
import androidx.constraintlayout.widget.ConstraintLayout
import com.barryyang.barryyangdemo.R
import com.barryyang.barryyangdemo.utils.LogUtil

/**
 * @author : BarryYang
 * @date : 2020/8/26 4:56 PM
 * @desc :
 */
class ConstraintActivity : AppCompatActivity() {

    private val TAG = "ConstraintActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
//        layerViewClick()
       // flowShow()
    }

//    private fun flowShow() {
//        val flow = findViewById<Flow>(R.id.flow)
//        val constraintLayout = findViewById<ConstraintLayout>(R.id.parent)
//        val intArrayOf = mutableListOf<Int>()
//        for (i in 0..10) {
//            val textView = TextView(this)
//            textView.setBackgroundColor(resources.getColor(R.color.colorAccent))
//            textView.setPadding(resources.getDimensionPixelSize(R.dimen.dimen_10), resources.getDimensionPixelSize(R.dimen.dimen_10)
//                    , resources.getDimensionPixelSize(R.dimen.dimen_10), resources.getDimensionPixelSize(R.dimen.dimen_10))
//            textView.id = generateViewId()
//            textView.text = "标签${i}"
//            textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//            constraintLayout.addView(textView)
//            intArrayOf.add(textView.id)
//        }
//        flow.referencedIds = intArrayOf.toIntArray()
//    }
//
//    private fun layerViewClick() {
//        findViewById<Layer>(R.id.layer).setOnClickListener {
//            LogUtil.printLogDebug(TAG, "可点击")
//        }
//    }

}