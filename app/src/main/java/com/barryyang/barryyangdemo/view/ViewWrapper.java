package com.barryyang.barryyangdemo.view;

import android.view.View;

/**
 * @author : BarryYang
 * @date : 2020/8/17 10:03 AM
 * @desc :
 */
public class ViewWrapper {

    private View mTargetView;

    public ViewWrapper(View view) {
        this.mTargetView = view;
    }

    public void setWidth(int width) {
        mTargetView.getLayoutParams().width = width;
        mTargetView.requestLayout();
    }

    public int getWidth() {
        return mTargetView.getLayoutParams().width;
    }
}
