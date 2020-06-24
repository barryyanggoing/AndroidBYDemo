package com.barryyang.designmode;

import com.barryyang.designmode.proxy.GamePlayerImpl;
import com.barryyang.designmode.proxy.GamePlayerProxyImpl;

import org.junit.Test;

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
        GamePlayerProxyImpl gamePlayerProxy = new GamePlayerProxyImpl("张三");
        gamePlayerProxy.login("", "");
        gamePlayerProxy.killBoss();
        gamePlayerProxy.upgrade();
    }
}