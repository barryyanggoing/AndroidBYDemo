package com.barryyang.barryyangdemo.designmodel.proxy;

/**
 * @author barryyang
 */
public class GamePlayerImpl implements IGamePlayer {

    private String name;

    public GamePlayerImpl(String name) {
        this.name = name;
    }

    @Override
    public void login(String username, String password) {
        System.out.println(name + "登录游戏");
    }

    @Override
    public void killBoss() {
        System.out.println(name + "击杀boss");
    }

    @Override
    public void upgrade() {
        System.out.println(name + "升级");
    }
}
