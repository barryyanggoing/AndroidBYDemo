package com.barryyang.barryyangdemo.kotlin.interfaces

/**
 * @author : BarryYang
 * @date : 2020/8/21 3:18 PM
 * @desc :在接⼝中声明的属性要么是抽象的，要么提供访问器的实现。
 */
interface CustomInterface {

    /**
     * 抽象的
     */
    val param: Int

    /**
     * 要么提供访问器的实现
     */
    val property: String get() = "foo"

    /**
     * 没有标记为抽象，在接⼝中没有⽅法体时默认为抽象
     */
    fun bar()

//    fun bar(){
//        print("sds")
//    }

}