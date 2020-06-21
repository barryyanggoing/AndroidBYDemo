package com.barryyang.designmode.factory;

public class SmsSender implements Sender {

    @Override
    public void send() {
        ///Log.i("barryyang.send", "send sms");
        System.out.println("send sms");
    }
}
