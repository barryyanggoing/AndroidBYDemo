package com.barryyang.barryyangdemo;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class VolumeView extends View {

    public static final int time = 5000;

    private Paint mPaint;

    private int radius;
    private int maxHeight;
    private int minHeight;
    private int margin;
    private int rectfWidth;
    private int random;
    private int recfCount = 1;
    private List<RectF> list = new ArrayList<>();

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
        add();
    }

    private void add() {
        for (int i = 0; i < recfCount; i++) {
            float left = (i + 1) * margin + i * rectfWidth;
            float right = (i + 1) * (margin + rectfWidth);
            float top = new Random().nextInt(random);
            float bottom = maxHeight - top;
            list.add(new RectF(left, top, right, bottom));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < list.size(); i++) {
            canvas.drawRoundRect(list.get(i), radius, radius, mPaint);
        }
    }

    public void invalidat() {
        showAnimator();
    }

    private void showAnimator() {

        RectF rectF = list.get(0);
        final int endTop = rectF.top == 0 ? minHeight : maxHeight;

        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = (int) animation.getAnimatedValue() / 100f;
                IntEvaluator intEvaluator = new IntEvaluator();
                int top = (int) list.get(0).top;
                Log.i("xx", top + "--" + maxHeight);
                int nowTop = intEvaluator.evaluate(fraction, 10, maxHeight);
                float nowBottom = maxHeight - nowTop;
                list.get(0).top = nowTop;
                list.get(0).bottom = nowBottom;
                invalidate();
            }
        });
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(2000);
        valueAnimator.start();
    }

}
