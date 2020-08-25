package com.barryyang.barryyangdemo.designmodel.builder;

import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * 宝马
 */
public class BmwModel extends AbstractCarModel {

    private static final String TAG = "BmwModel";

    @Override
    protected void start() {
        LogUtil.printLogDebug(TAG, "start");
    }

    @Override
    protected void stop() {
        LogUtil.printLogDebug(TAG, "stop");
    }

    @Override
    protected void alarm() {
        LogUtil.printLogDebug(TAG, "alarm");
    }

    @Override
    protected void engineBoom() {
        LogUtil.printLogDebug(TAG, "engineBoom");
    }
}
