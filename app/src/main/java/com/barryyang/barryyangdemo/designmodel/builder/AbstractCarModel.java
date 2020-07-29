package com.barryyang.barryyangdemo.designmodel.builder;

import java.util.ArrayList;

/**
 * 车子模型
 *
 * @author barryyang
 */
public abstract class AbstractCarModel {

    private ArrayList<String> sequence = new ArrayList<>();

    /**
     * 车子启动
     */
    protected abstract void start();

    /**
     * 车子停下
     */
    protected abstract void stop();

    /**
     * 车子拧喇叭
     */
    protected abstract void alarm();

    /**
     * 引擎响声
     */
    protected abstract void engineBoom();

    final public void run() {
        for (String s : sequence) {

        }
    }

    final public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}
