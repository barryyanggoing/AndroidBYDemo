package com.barryyang.barryyangdemo.android.constraint

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.constraintlayout.widget.ConstraintLayout

class CircularRevealHelper : ConstraintHelper {

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun updatePostLayout(container: ConstraintLayout) {
        super.updatePostLayout(container)
        val views = getViews(container)
        views.forEach {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startEnterAnimation(it)
            }
        }
    }

    private fun startEnterAnimation(view: View) {
        val translationY = -100f
        view.translationY = translationY
        val translationYHolder = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, translationY, 0f)
        val keyFrame1 = Keyframe.ofFloat(0f, -6f)
        val keyFrame2 = Keyframe.ofFloat(0.6f, 25f)
        val keyFrame3 = Keyframe.ofFloat(1f, 0f)
        val rotateHolder = PropertyValuesHolder.ofKeyframe(View.ROTATION, keyFrame1, keyFrame2, keyFrame3)
        ObjectAnimator.ofPropertyValuesHolder(view, translationYHolder, rotateHolder)
                .apply { interpolator = AnticipateOvershootInterpolator() }
                .setDuration(600L)
                .start()
    }
}