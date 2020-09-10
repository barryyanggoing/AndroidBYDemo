package com.barryyang.barryyangdemo.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/8/14 10:30 PM
 * @desc :
 */
public class DispatchViewGroup extends LinearLayout {

    private static final String TAG = "DispatchViewGroup";

    public DispatchViewGroup(Context context) {
        this(context,null);
    }

    public DispatchViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DispatchViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.printLogDebug(TAG,"dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        LogUtil.printLogDebug(TAG,"onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.printLogDebug(TAG,"onTouchEvent");
        return super.onTouchEvent(event);
    }

}
