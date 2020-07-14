package com.barryyang.designmode;

import androidx.annotation.NonNull;

import com.barryyang.designmode.abstract_factory.AbstractFactory;
import com.barryyang.designmode.abstract_factory.Color;
import com.barryyang.designmode.abstract_factory.FactoryProvider;
import com.barryyang.designmode.adapter.AudioMediaPlayer;
import com.barryyang.designmode.bridge.Circle;
import com.barryyang.designmode.bridge.RedCircle;
import com.barryyang.designmode.factory.IHuman;
import com.barryyang.designmode.factory.PeopleFactory;
import com.barryyang.designmode.interceptor.DebugInterceptor;
import com.barryyang.designmode.interceptor.DefaultInterceptor;
import com.barryyang.designmode.interceptor.InterceptorCallBack;
import com.barryyang.designmode.interceptor.MediaPlayerSetting;
import com.barryyang.designmode.interceptor.ReleaseInterceptor;
import com.barryyang.designmode.observer.BinaryObserver;
import com.barryyang.designmode.observer.Observable;
import com.barryyang.designmode.proxy.GamePlayIH;
import com.barryyang.designmode.proxy.GamePlayerImpl;
import com.barryyang.designmode.proxy.GamePlayerProxyImpl;
import com.barryyang.designmode.proxy.IGamePlayer;
import com.barryyang.designmode.singleton.Singleton;
import com.barryyang.designmode.strategy.Context;
import com.barryyang.designmode.strategy.XmStrategy;
import com.barryyang.designmode.yuanxing.Shape;
import com.barryyang.designmode.yuanxing.ShapeCache;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

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
//        AbstractFactory abstractFactory = FactoryProvider.getFactory("color");
//        Color white = abstractFactory.getColor("white");
//        white.getColor();
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
        //观察者模式
//        Observable observable = new Observable();
//        BinaryObserver binaryObserver = new BinaryObserver(observable);
//        observable.setState("11");
        //原型模式
//        ShapeCache.loadCache();
//        Shape shape = ShapeCache.getShape("1");
//        System.out.println(shape.getType());
        //适配器模式
//        AudioMediaPlayer audioMediaPlayer = new AudioMediaPlayer();
//        audioMediaPlayer.play("mp3","MP3 path");
        //桥接模式
//        Circle circle = new Circle(1, 1, 1, new RedCircle());
//        circle.draw();
        MediaPlayerSetting.Builder builder = new MediaPlayerSetting.Builder()
                .addPrePlayInterceptor(new DebugInterceptor())
                .addPrePlayInterceptor(new ReleaseInterceptor());
        builder.build();

        DefaultInterceptor defaultInterceptor = new DebugInterceptor();
        defaultInterceptor.interceptor("debug", new InterceptorCallBack() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailed() {
                System.out.println("debug");
            }
        });
    }

}