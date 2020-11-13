package com.barryyang.barryyangdemo.kotlin.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.barryyang.barryyangdemo.R
import com.barryyang.barryyangdemo.utils.LogUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * @author : BarryYang
 * @date : 2020/8/3 4:23 PM
 * @desc :kotlin的使用
 */
class KotlinActivity : AppCompatActivity() {

    private val TAG = "KotlinActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        Observable.range(1, 5)
                .repeatWhen { objectObservable -> objectObservable.delay(1, TimeUnit.SECONDS) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ integer -> LogUtil.printLogDebug(TAG, "accept-->$integer") }) { LogUtil.printLogDebug(TAG, "accept-->throwable") }
    }

    fun jumpAdapter(view: View) {
        startActivity(Intent(this, KotlinAdapterActivity::class.java))
    }

    fun jumpCoroutine(view: View) {
        startActivity(Intent(this, KotlinCoroutineActivity::class.java))
    }

}