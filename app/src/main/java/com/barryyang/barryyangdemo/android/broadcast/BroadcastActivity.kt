package com.barryyang.barryyangdemo.android.broadcast

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.barryyang.barryyangdemo.R


/**
 * @author : BarryYang
 * @date : 2020/9/8 9:58 AM
 * @desc :
 */
class BroadcastActivity : AppCompatActivity() {

    var action = "com.byd.action.AUTOVOICE_SEARCH"
    var EXTRA_KEYWORDS_SEARCH = "EXTRA_KEYWORDS_SEARCH"
    var EXTRA_ARTIST_SEARCH = "EXTRA_ARTIST_SEARCH"
    var IS_BACKGROUND = "IS_BACKGROUND"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broastcast)
    }

    /**
     * 芽芽故事比亚迪智能语音测试
     */
    fun staticBroadcast(view: View) {
        val intent = Intent(action)
        intent.setPackage("com.lazyaudio.yayagushi")
        intent.putExtra(EXTRA_KEYWORDS_SEARCH, "芽芽睡前故事")
        intent.putExtra(EXTRA_ARTIST_SEARCH, "歪歪兔")
        intent.putExtra(IS_BACKGROUND, false)
        sendBroadcast(intent)
    }
}