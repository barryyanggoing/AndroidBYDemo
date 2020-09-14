package com.barryyang.barryyangdemo.kotlin.collection

/**
 * @author : BarryYang
 * @date : 2020/9/10 6:00 PM
 * @desc :
 */
class Version(private val major: Int, private val minor: Int) : Comparable<Version> {

    override fun compareTo(other: Version): Int {
        return if (this.major != other.major) {
            this.major - other.major
        } else if (this.minor != other.minor) {
            this.minor - other.minor
        } else 0
    }
}