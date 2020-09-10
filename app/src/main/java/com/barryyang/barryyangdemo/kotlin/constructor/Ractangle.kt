package com.barryyang.barryyangdemo.kotlin.constructor

/**
 * @author : BarryYang
 * @date : 2020/8/20 4:25 PM
 * @desc :
 */
open class Ractangle :Shape(){

    override val s: Int
        get() = 1

    val borderColor: String = "black"

    val isEmpty: Boolean get() = true

    var stringRepresentation: String
        get() = this.toString()
        set(value){
            "sdsdss"
        }

    open fun draw() {
        print("drawinga rectangle")
    }


}