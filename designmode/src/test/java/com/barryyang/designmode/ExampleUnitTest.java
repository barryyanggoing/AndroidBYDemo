package com.barryyang.designmode;

import androidx.annotation.NonNull;

import com.barryyang.designmode.abstract_factory.AbstractFactory;
import com.barryyang.designmode.abstract_factory.Color;
import com.barryyang.designmode.abstract_factory.FactoryProvider;
import com.barryyang.designmode.factory.IHuman;
import com.barryyang.designmode.factory.PeopleFactory;
import com.barryyang.designmode.proxy.GamePlayIH;
import com.barryyang.designmode.proxy.GamePlayerImpl;
import com.barryyang.designmode.proxy.GamePlayerProxyImpl;
import com.barryyang.designmode.proxy.IGamePlayer;
import com.barryyang.designmode.singleton.Singleton;
import com.barryyang.designmode.strategy.Context;
import com.barryyang.designmode.strategy.XmStrategy;

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
//        IHuman yellow = PeopleFactory.getPeople("yellow");
//        yellow.getHumanColor();
//        yellow.humanTalk();
        //抽象工厂模式
        AbstractFactory abstractFactory = FactoryProvider.getFactory("color");
        Color white = abstractFactory.getColor("white");
        white.getColor();
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
//        IGamePlayer player = new GamePlayerImpl("张三");
//        InvocationHandler invocationHandler = new GamePlayIH(player);
//        ClassLoader classLoader = player.getClass().getClassLoader();
//        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, invocationHandler);
//        proxy.login("", "");
//        proxy.killBoss();
//        proxy.upgrade();
        //策略模式
//        XmStrategy xmStrategy = new XmStrategy();
//        Context context = new Context(xmStrategy);
//        context.excuteStrategy();
        //单例模式
        //Singleton.getInstance().setMessage();
    }

}