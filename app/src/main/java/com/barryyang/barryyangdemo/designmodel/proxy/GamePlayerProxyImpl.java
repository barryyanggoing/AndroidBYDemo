package com.barryyang.barryyangdemo.designmodel.proxy;

public class GamePlayerProxyImpl implements IGamePlayer {

    IGamePlayer gamePlayer;

    public GamePlayerProxyImpl(String name) {
        if (this.gamePlayer == null) {
            this.gamePlayer = new GamePlayerImpl(name);
        }
    }

    @Override
    public void login(String username, String password) {
        gamePlayer.login(username, password);
    }

    @Override
    public void killBoss() {
        gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        gamePlayer.upgrade();
    }
}
