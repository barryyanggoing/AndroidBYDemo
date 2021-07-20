package com.xigua.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author : BarryYang
 * @date : 2021/7/18 4:08 下午
 * @desc :
 */
public class EventDispatchView extends View {

    public EventDispatchView(Context context) {
        super(context);
    }

    public EventDispatchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EventDispatchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("BarryYang","EventDispatchView -> dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("BarryYang","EventDispatchView -> onTouchEvent");
        return super.onTouchEvent(event);
    }
}
