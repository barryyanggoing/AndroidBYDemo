package com.barryyang.designmode;

import com.barryyang.designmode.builder.BenzModel;
import com.barryyang.designmode.builder.Builder;
import com.barryyang.designmode.builder.MyData;
import com.barryyang.designmode.builder.ProductBuilder;
import com.barryyang.designmode.dimite.Gril;
import com.barryyang.designmode.dimite.GrounpLeader;
import com.barryyang.designmode.dimite.InstallSoftware;
import com.barryyang.designmode.dimite.Teacher;
import com.barryyang.designmode.dimite.Wizard;
import com.barryyang.designmode.factory.Factory;
import com.barryyang.designmode.factory.Product;
import com.barryyang.designmode.factory.ProductAFactory;
import com.barryyang.designmode.kaibi.BookStore;
import com.barryyang.designmode.lishitihuan.Button;
import com.barryyang.designmode.lishitihuan.TextView;
import com.barryyang.designmode.lishitihuan.Window;
import com.barryyang.designmode.singleton.Singleton;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
    }
}