package com.barryyang.barryyangdemo.kotlin.demo

/**
 * @author : BarryYang
 * @date : 2020/9/15 10:35 AM
 * @desc :
 */
sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}