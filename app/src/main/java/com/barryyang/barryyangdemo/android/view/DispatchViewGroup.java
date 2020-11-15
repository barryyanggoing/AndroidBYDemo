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
        this(context, null);
    }

    public DispatchViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DispatchViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.printLogDebug("DispatchViewGroup->dispatchTouchEvent:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.printLogDebug("DispatchViewGroup->dispatchTouchEvent:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.printLogDebug("DispatchViewGroup->dispatchTouchEvent:ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                LogUtil.printLogDebug("DispatchViewGroup->dispatchTouchEvent:ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.printLogDebug("DispatchViewGroup->onInterceptTouchEvent:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.printLogDebug("DispatchViewGroup->onInterceptTouchEvent:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.printLogDebug("DispatchViewGroup->onInterceptTouchEvent:ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                LogUtil.printLogDebug("DispatchViewGroup->onInterceptTouchEvent:ACTION_CANCEL");
                break;
        }
        return super.onInterceptTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.printLogDebug("DispatchViewGroup->onTouchEvent:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.printLogDebug("DispatchViewGroup->onTouchEvent:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.printLogDebug("DispatchViewGroup->onTouchEvent:ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                LogUtil.printLogDebug("DispatchViewGroup->onTouchEvent:ACTION_CANCEL");
                break;
        }
        return super.onTouchEvent(ev);
    }

}
