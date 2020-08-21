package com.barryyang.barryyangdemo.kotlin.constructor

/**
 * @author : BarryYang
 * @date : 2020/8/20 4:25 PM
 * @desc :
 */
class FilledRactangle : Ractangle() {

    val borderFilledColor: String = super.borderColor

    override fun draw() {
        super.draw()
        print("drawinga fillted rectangle")
    }

    inner class Filter {

        fun fill() {

        }

        fun drawAndFill() {
            //内部类中访问外部类的超类
            super@FilledRactangle.draw()
            fill()
        }
    }
}