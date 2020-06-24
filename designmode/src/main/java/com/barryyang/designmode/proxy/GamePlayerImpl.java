package com.barryyang.designmode.proxy;

public class GamePlayerImpl implements IGamePlayer {

    @Override
    public void login(String username, String password) {
        System.out.println("登录游戏");
    }

    @Override
    public void killBoss() {
        System.out.println("击杀boss");
    }

    @Override
    public void upgrade() {
        System.out.println("升级");
    }
}
