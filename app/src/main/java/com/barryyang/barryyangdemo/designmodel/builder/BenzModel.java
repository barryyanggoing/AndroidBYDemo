package com.barryyang.barryyangdemo.designmodel.builder;

import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * 奔驰
 */
public class BenzModel extends AbstractCarModel {

    private static final String TAG = "BenzModel";

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
