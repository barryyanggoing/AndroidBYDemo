package com.barryyang.barryyangdemo.kotlin.`return`

/**
 * @author : BarryYang
 * @date : 2020/9/17 5:35 PM
 * @desc :
 * return。默认从最直接包围它的函数或者匿名函数返回。
 * break。终⽌最直接包围它的循环。
 * continue。继续下⼀次最直接包围它的循环。
 */
fun main() {
    breakMethod()
    returnMethod()
}

fun returnMethod(){
    listOf(1,2,3,4,5).forEach lit@{
        if (it == 3){
            return@lit
        }
        println(it)
    }
    println("结束")
}

fun breakMethod() {
    loop@ for (i in 1..100) {
        println("第一层循环：${i}")
        for (j in 1..100) {
            println("第二层循环:${j}")
            if (j == 1) {
                println("j==1")
                break@loop
            }
        }
    }
}