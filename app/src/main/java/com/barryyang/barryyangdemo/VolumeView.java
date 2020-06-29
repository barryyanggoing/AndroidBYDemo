package com.barryyang.barryyangdemo;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;
import java.util.Random;

public class VolumeView extends View {

    private Paint mPaint;

    private int radius;
    private int maxHeight;
    private int minHeight;
    private int margin;
    private int rectfWidth;
    private int random;
    private int recfCount = 1;
    RectF rectF;

    public VolumeView(Context context) {
        this(context, null);
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        maxHeight = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_40);
        minHeight = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_10);
        margin = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_15);
        rectfWidth = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_10);
        random = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_15);
        radius = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_5);
        rectF = new RectF(0, minHeight, rectfWidth, maxHeight - minHeight);
        showAnimator();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(rectF, radius, radius, mPaint);
    }

    private void showAnimator() {
        final int top = (int) rectF.top;
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = (int) animation.getAnimatedValue() / 100f;
                IntEvaluator intEvaluator = new IntEvaluator();
                int nowTop = intEvaluator.evaluate(fraction, top, 0);
                float nowBottom = maxHeight - nowTop;
                rectF.top = nowTop;
                rectF.bottom = nowBottom;
                invalidate();
            }
        });
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(new Random().nextInt(200) + 300);
        valueAnimator.setStartDelay(new Random().nextInt(300));
        valueAnimator.start();
    }

}
