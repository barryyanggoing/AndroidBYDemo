package com.barryyang.barryyangdemo.constraint

import android.content.Context
import android.util.AttributeSet
import android.view.ViewAnimationUtils
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * @author : BarryYang
 * @date : 2020/8/27 2:46 PM
 * @desc :
 */
class AdHelper : ConstraintHelper {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun updatePostLayout(container: ConstraintLayout?) {
        super.updatePostLayout(container)
        val views = getViews(container)
        views.forEach {
            val createCircularReveal = ViewAnimationUtils.createCircularReveal(it, 0, 0, 0f, it.width.toFloat())
            createCircularReveal.duration = 2000
            createCircularReveal.start()
        }
    }

}