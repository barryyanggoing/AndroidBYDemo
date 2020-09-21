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

/**
 * 1.inline:声明在编译的时候，将函数的代码拷贝到调用的地方（内联）
 * 2.oninline:声明在inline函数的形参中，不希望内联的lambda表达式
 * 3.crossinline:表明inline函数的形参中的lambda表达式不能有return,可以有return@label
 */
inline fun <reified T : Activity> Activity.startActivity() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified F : Fragment> Context.newFragment(vararg args: Pair<String, String>): F {
    val bundle = Bundle()
    args.let {
        for (arg in args) {
            bundle.putString(arg.first, arg.second)
        }
    }
    return Fragment.instantiate(this, F::class.java.name, bundle) as F
}

inline fun <reified T : Any> Gson.fromJson(json: String): T {
    return Gson().fromJson(json, T::class.java)
}

/**
 * 当你的函数中有 lambda 形参时，inline 的优势才会体现。
 */
inline fun sum(a: Int, b: Int, lambda: (result: Int) -> Unit): Int {
    val r = a + b
    lambda.invoke(r)
    return r
}

/**
 * crossinline：不允许inline形参中的lambda表达式有return语句(可以有 return@label 语句)，避免影响外部流程，否则会报错
 */
inline fun sum1(a: Int, b: Int, crossinline lambda: (result: Int) -> Unit): Int {
    val r = a + b
    lambda.invoke(r)
    return r
}

/**
 * noinline:inline 形参中的lambda不想内联
 */
inline fun sum2(a: Int, b: Int, lambda: (result: Int) -> Unit, noinline lambda1: (result: Int) -> Unit): Int {
    val r = a + b
    lambda.invoke(r)
    return r
}

private const val t = "sd"

/**
 * public inline不能访问私有属性
 */
private inline fun test(l: () -> Unit) {
    l()
    println(t)
}

/**
 * sum没有内联的时候
 * 在每次循环里都会创建一个 Function1 的实例对象。这里就是性能的优化点所在，如何避免在循环里创建新的对象？
 */
fun main() {
//    val r: (Int) -> Unit = {
//        println("result is $it")
//    }
//    for (i in 1..10) {
//        sum(1, 2, lambda = {
//            println("result is $it")
//        })
//    }
//    sum1(1, 2, lambda = {
//        println("result is $it")
//        return@sum1
//    })
    sum2(1, 2, lambda = {

    }, lambda1 = {

    })
}