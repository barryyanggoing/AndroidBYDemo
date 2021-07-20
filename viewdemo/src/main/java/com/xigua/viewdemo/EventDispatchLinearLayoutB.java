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
public class EventDispatchLinearLayoutB extends LinearLayout {

    public EventDispatchLinearLayoutB(Context context) {
        super(context);
    }

    public EventDispatchLinearLayoutB(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EventDispatchLinearLayoutB(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean b = super.dispatchTouchEvent(ev);
        Log.i("BarryYang","EventDispatchLinearLayoutB -> dispatchTouchEvent ->" + b);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("BarryYang","EventDispatchLinearLayoutB -> onInterceptTouchEvent");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("BarryYang","EventDispatchLinearLayoutB -> onTouchEvent");
        return super.onTouchEvent(event);
    }
}
