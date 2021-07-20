package com.xigua.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author : BarryYang
 * @date : 2021/7/18 4:08 下午
 * @desc :
 */
public class EventDispatchLinearLayoutA extends LinearLayout {

    public EventDispatchLinearLayoutA(Context context) {
        super(context);
    }

    public EventDispatchLinearLayoutA(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EventDispatchLinearLayoutA(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("BarryYang","EventDispatchLinearLayoutA -> dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("BarryYang","EventDispatchLinearLayoutA -> onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("BarryYang","EventDispatchLinearLayoutA -> onTouchEvent");
        return super.onTouchEvent(event);
    }
}
