package com.barryyang.designmode;

import androidx.annotation.NonNull;

import com.barryyang.designmode.proxy.GamePlayIH;
import com.barryyang.designmode.proxy.GamePlayerImpl;
import com.barryyang.designmode.proxy.GamePlayerProxyImpl;
import com.barryyang.designmode.proxy.IGamePlayer;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        //工厂模式
//        Factory factory = new ProductAFactory();
//        Product product = factory.createProduct();
//        product.createName();
        //单例模式
//        String designModeName = Singleton.getInstance().getDesignModeName();
//        System.out.println(designModeName);
        //builder模式
//        new MyData.MyBuilder().setNumber(1).setNumber1(1).build();
//        BenzModel benzModel = new BenzModel();
//        ArrayList<String> list = new ArrayList<>();
//        list.add("");
//        list.add("");
//        list.add("");
//        benzModel.setSequence(list);
//        benzModel.run();
//        Builder builder = new ProductBuilder();
//        builder.setPartName("ssss");
//        builder.build();
        //代理模式
//        GamePlayerProxyImpl gamePlayerProxy = new GamePlayerProxyImpl("张三");
//        gamePlayerProxy.login("", "");
//        gamePlayerProxy.killBoss();
//        gamePlayerProxy.upgrade();
        IGamePlayer player = new GamePlayerImpl("张三");
        InvocationHandler invocationHandler = new GamePlayIH(player);
        ClassLoader classLoader = player.getClass().getClassLoader();
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, invocationHandler);
        proxy.login("", "");
        proxy.killBoss();
        proxy.upgrade();
    }

}