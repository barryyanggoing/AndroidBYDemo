package com.barryyang.designmode;

import com.barryyang.designmode.builder.MyData;
import com.barryyang.designmode.lishitihuan.Button;
import com.barryyang.designmode.lishitihuan.TextView;
import com.barryyang.designmode.lishitihuan.Window;
import com.barryyang.designmode.singleton.Singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
//        SendFactory sendFactory = new SendFactory();
//        Sender sms = sendFactory.productSms();
//        sms.send();
//        Sender productStaticMail = SendFactory.productStaticMail();
//        productStaticMail.send();
//        String designModeName = Singleton.getInstance().getDesignModeName();
//        System.out.println(designModeName);
        //里氏替换原则
//        Window window = new Window();
//        window.show(new Button());
//        window.show(new TextView());
        //builder模式
      //  new MyData.MyBuilder().setNumber(1).setNumber1(1).build();
    }
}