package com.barryyang.barryyangdemo.view;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

import com.barryyang.barryyangdemo.R;

import java.util.Random;

/**
 * @author barryyang
 */
public class VolumeView extends View {

    /**
     * 长方形音量圆角
     */
    private int mRectRadius;

    /**
     * 最大高度
     */
    private int mMaxHeight;

    /**
     * 最小高度
     */
    private int mMinHeight;

    /**
     * 长方形宽度
     */
    private int mRectWidth;

    /**
     * 长方形颜色
     */
    private int mRectColor;

    /**
     * 执行动画延迟时间
     */
    private int mDelayTime;

    /**
     * 执行动画随机加上的时间
     */
    private int mRandomTime;

    /**
     * 执行动画初始时间
     */
    private int mStartTime;

    private Paint mPaint;
    private RectF mRectF;

    private ValueAnimator mValueAnimator;

    public VolumeView(Context context) {
        this(context, null);
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.VolumeView);
        mMaxHeight = typedArray.getDimensionPixelSize(R.styleable.VolumeView_volume_view_maxHeight, getResources().getDimensionPixelSize(R.dimen.dimen_40));
        mMinHeight = typedArray.getDimensionPixelSize(R.styleable.VolumeView_volume_view_minHeight, getResources().getDimensionPixelSize(R.dimen.dimen_15));
        mRectWidth = typedArray.getDimensionPixelSize(R.styleable.VolumeView_volume_view_rectWidth, getResources().getDimensionPixelSize(R.dimen.dimen_10));
        mRectRadius = typedArray.getDimensionPixelSize(R.styleable.VolumeView_volume_view_radius, getResources().getDimensionPixelSize(R.dimen.dimen_5));
        mRectColor = typedArray.getColor(R.styleable.VolumeView_volume_view_color, Color.RED);
        mDelayTime = typedArray.getInteger(R.styleable.VolumeView_volume_view_delayTime, 500);
        mRandomTime = typedArray.getInteger(R.styleable.VolumeView_volume_view_randomTime, 300);
        mStartTime = typedArray.getInteger(R.styleable.VolumeView_volume_view_startTime, 500);
        typedArray.recycle();
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mRectColor);
        mPaint.setAntiAlias(true);
        mRectF = new RectF(0, mMinHeight, mRectWidth, mMaxHeight - mMinHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(mRectF, mRectRadius, mRectRadius, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int widthMeasureSpec) {
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        switch (mode) {
            case MeasureSpec.AT_MOST:
                //最大值模式 当控件的layout_Width或layout_height属性指定为wrap_content时
                size = Math.min(mRectWidth, size);
                break;
            case MeasureSpec.EXACTLY:
                //精确值模式 当控件的android:layout_width=”100dp”或android:layout_height=”match_parent”时

                break;
            default:
                size = mRectWidth;
                break;
        }
        return size;
    }

    private int measureHeight(int heightMeasureSpec) {
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);
        switch (mode) {
            case MeasureSpec.AT_MOST:
                //最大值模式 当控件的layout_Width或layout_height属性指定为wrap_content时
                size = Math.min(mMaxHeight, size);
                break;
            case MeasureSpec.EXACTLY:
                //精确值模式 当控件的android:layout_width=”100dp”或android:layout_height=”match_parent”时

                break;
            default:
                size = mMaxHeight;
                break;
        }
        return size;
    }

    private void showAnimation() {
        final int top = (int) mRectF.top;
        mValueAnimator = ValueAnimator.ofInt(0, 100);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = (int) animation.getAnimatedValue() / 100f;
                IntEvaluator intEvaluator = new IntEvaluator();
                int nowTop = intEvaluator.evaluate(fraction, top, 0);
                float nowBottom = mMaxHeight - nowTop;
                mRectF.top = nowTop;
                mRectF.bottom = nowBottom;
                invalidate();
            }
        });
        mValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mValueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mValueAnimator.setInterpolator(new LinearInterpolator());
        mValueAnimator.setDuration(new Random().nextInt(mRandomTime) + mStartTime);
        mValueAnimator.setStartDelay(new Random().nextInt(mDelayTime));
        mValueAnimator.start();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        showAnimation();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mValueAnimator != null) {
            mValueAnimator.cancel();
            mValueAnimator.removeAllListeners();
            mValueAnimator = null;
        }
    }
}
