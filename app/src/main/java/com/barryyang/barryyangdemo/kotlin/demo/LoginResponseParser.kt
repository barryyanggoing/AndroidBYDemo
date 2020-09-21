package com.barryyang.barryyangdemo.kotlin.demo

import com.barryyang.barryyangdemo.utils.LogUtil
import java.io.InputStream

/**
 * @author : BarryYang
 * @date : 2020/9/15 10:38 AM
 * @desc :
 */
class LoginResponseParser {

    private val TAG = "LoginResponseParser"

    fun parse(inputStream: InputStream?): String {
        var ch: Int
        val sb = StringBuilder()
        while (inputStream!!.read().also { ch = it } != -1) sb.append(ch.toChar())
        LogUtil.printLogDebug(TAG, sb.toString())
        return sb.toString()
    }
}