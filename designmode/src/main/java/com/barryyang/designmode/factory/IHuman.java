package com.barryyang.designmode.factory;

/**
 * @author barryyang
 */
public interface IHuman {

    /**
     * 获取皮肤颜色
     *
     * @return 皮肤颜色
     */
    String getHumanColor();

    /**
     * 说话
     */
    void humanTalk();
}
