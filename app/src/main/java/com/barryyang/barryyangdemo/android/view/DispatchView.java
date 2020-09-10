package com.barryyang.barryyangdemo.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/8/14 10:30 PM
 * @desc :
 */
public class DispatchView extends View {

    private static final String TAG = "DispatchView";

    public DispatchView(Context context) {
        this(context,null);
    }

    public DispatchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DispatchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        LogUtil.printLogDebug(TAG,"dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.printLogDebug(TAG,"onTouchEvent");
        return super.onTouchEvent(event);
    }
}
