package com.barryyang.designmode.factory;

public class MailSender implements Sender{
    @Override
    public void send() {
//        Log.i("barryyang.send", "mail sms");
        System.out.println("mail");
    }
}
