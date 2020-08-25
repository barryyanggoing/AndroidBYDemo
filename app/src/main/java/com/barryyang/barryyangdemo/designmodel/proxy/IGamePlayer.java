package com.barryyang.barryyangdemo.designmodel.proxy;

/**
 * @author barryyang
 */
public interface IGamePlayer {

    /**
     * 登录游戏
     *
     * @param username
     * @param password
     */
    void login(String username, String password);

    /**
     * 杀怪
     */
    void killBoss();

    /**
     * 升级
     */
    void upgrade();
}
