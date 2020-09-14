package com.barryyang.barryyangdemo.kotlin.coroutine

import kotlinx.coroutines.*

/**
 * @author : BarryYang
 * @date : 2020/9/11 2:40 PM
 * @desc :
 */
fun main(){
    GlobalScope.launch(Dispatchers.IO) {
        println(Thread.currentThread().name)
    }
}

fun launch(){
//    val coroutineScope = CoroutineScope()
//    /**
//     * 这个 launch 函数，它具体的含义是：我要创建一个新的协程，并在指定的线程上运行它。
//     * 这个被创建、被运行的所谓「协程」是谁？就是你传给 launch 的那些代码，这一段连续代码叫做一个「协程」。
//     */
//    coroutineScope.launch (Dispatchers.Main){//在UI线程开始
//        //执行代码
//        val image = getImage(1)
//        imageview.setImageBitmap(image)//回到UI线程更新UI
//    }
}

/**
 * 「代码执行到 suspend 函数的时候会『挂起』，并且这个『挂起』是非阻塞式的，它不会阻塞你当前的线程。」
 */
suspend fun getImage(id:Int) = withContext(Dispatchers.IO){//切换到IO线程，并在执行完成后切回UI线程
    //请求
}