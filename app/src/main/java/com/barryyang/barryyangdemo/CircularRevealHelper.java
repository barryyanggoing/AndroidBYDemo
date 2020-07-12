package com.barryyang.barryyangdemo;

import android.animation.Animator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;

import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CircularRevealHelper extends ConstraintHelper {

    public CircularRevealHelper(Context context) {
        super(context);
    }

    public CircularRevealHelper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularRevealHelper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void updatePostLayout(ConstraintLayout container) {
        super.updatePostLayout(container);
        View[] views = getViews(container);
        for (View v : views) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                double hypot = Math.hypot(v.getHeight() / 2.0d, v.getWidth() / 2.0d);
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(v, v.getWidth() / 2, v.getHeight() / 2, 0, (float) hypot);
                circularReveal.setDuration(3000);
                circularReveal.start();
            }
        }
    }
}
