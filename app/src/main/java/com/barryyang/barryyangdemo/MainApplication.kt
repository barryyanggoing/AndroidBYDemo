package com.barryyang.barryyangdemo

import android.app.Activity
import android.app.Application
import android.content.Context
import com.barryyang.barryyangdemo.MainApplication
import com.barryyang.barryyangdemo.android.scopedstorage.ScopedStorageManager
import com.barryyang.barryyangdemo.android.scopedstorage.DownloadFileTransfer
import com.barryyang.barryyangdemo.utils.PreferenceUtil
import androidx.multidex.MultiDex
import com.barryyang.barryyangdemo.utils.LogUtil

/**
 * @author : BarryYang
 * @date : 2020/8/5 10:37 AM
 * @desc :
 */
class MainApplication : Application() {

    companion object {
        private const val TAG = "MainApplication"
//        private var application: Application? = null
//        @JvmStatic
//        fun provide(): Application? {
//            return application
//        }


        lateinit var application: MainApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        LogUtil.printLogDebug(TAG, "onCreate()")
        ScopedStorageManager.getInstance().createFile()
        DownloadFileTransfer.getInstance().transfer()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        LogUtil.printLogDebug(TAG, "attachBaseContext()")
        val integerByKey = PreferenceUtil.getInstance(this).getIntegerByKey(PreferenceUtil.PrefKey.PREF_KEY_CRASH_COUNT, 0)
        LogUtil.printLogDebug(TAG, integerByKey.toString())
        MultiDex.install(this)
    }


}