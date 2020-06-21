package com.barryyang.designmode.factory;

public class SendFactory {

    public Sender send(String sendType) {
        if (sendType.equals("sms")) {
            return new SmsSender();
        } else if (sendType.equals("mail")) {
            return new MailSender();
        }
        return null;
    }

    public Sender productMail(){
        return new MailSender();
    }

    public Sender productSms(){
        return new SmsSender();
    }

    public static Sender productStaticMail(){
        return new MailSender();
    }
}