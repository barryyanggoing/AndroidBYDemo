package com.barryyang.barryyangdemo.kotlin.inline

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.gson.Gson

/**
 * @author : BarryYang
 * @date : 2020/9/9 5:14 PM
 * @desc :内联函数
 */

//inline fun <reified T : Activity> Activity.startActivity() {
//    startActivity(Intent(this, T::class.java))
//}
//
//inline fun <reified F : Fragment> Context.newFragment(vararg args: Pair<String, String>): F {
//    val bundle = Bundle()
//    args.let {
//        for (arg in args) {
//            bundle.putString(arg.first, arg.second)
//        }
//    }
//    return Fragment.instantiate(this, F::class.java.name, bundle) as F
//}

inline fun test1(noinline inlined: (String) -> Unit) {
    test2(inlined)
}

fun test2(inlined: (String) -> Unit){

}

inline fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * 内联函数，扩展函数
 */
inline fun <reified T : Any> Gson.fromJson(json: String): T {
    return Gson().fromJson(json, T::class.java)
}

fun main() {
    sum(1, 2)
    sum(11, 12)
}