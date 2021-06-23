package com.barryyang.barryyangdemo.android.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * @author : BarryYang
 * @date : 2021/6/23 11:52 上午
 * @desc :
 */
public class QQAnimation extends Animation {

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        // 50越大频率越高，8越小振幅越小
        t.getMatrix().setTranslate(
                (float) Math.sin(interpolatedTime * 20) * 16,
                (float) Math.sin(interpolatedTime * 20) * 16
        );
        super.applyTransformation(interpolatedTime, t);
    }
}
