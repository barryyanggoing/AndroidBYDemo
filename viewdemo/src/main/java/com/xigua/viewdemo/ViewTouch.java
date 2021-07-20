package com.xigua.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import androidx.annotation.Nullable;

/**
 * @author : BarryYang
 * @date : 2021/7/18 2:13 下午
 * @desc :
 */
public class ViewTouch extends View {

    private float mLastX;
    private float mLastY;

    public ViewTouch(Context context) {
        super(context);
    }

    public ViewTouch(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewTouch(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int defaultWidth = dp2dx(80);
        int defaultHeight = dp2dx(40);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;

        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            Log.i("BarryYang", "111");
            width = widthSize;
            height = heightSize;
        } else if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.AT_MOST) {
            Log.i("BarryYang", "222");
            width = widthSize;
            height = defaultHeight;
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.EXACTLY) {
            Log.i("BarryYang", "333");
            width = defaultWidth;
            height = heightSize;
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            Log.i("BarryYang", "444");
            width = defaultWidth;
            height = defaultHeight;
        } else {
            Log.i("BarryYang", "555");
            width = widthSize;
            height = heightSize;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            float delaX = rawX - mLastX;
            float delaY = rawY - mLastY;
            setTranslationX(getTranslationX() + delaX);
            setTranslationY(getTranslationY() + delaY);
        }
        mLastX = rawX;
        mLastY = rawY;
        return true;
    }

    private int dp2dx(int px) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        return (int) (px * density + 0.5);
    }
}
