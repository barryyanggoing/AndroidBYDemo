package com.barryyang.designmode;

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
        Sender productStaticMail = SendFactory.productStaticMail();
        productStaticMail.send();
    }
}