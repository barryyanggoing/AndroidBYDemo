package com.barryyang.designmode.factory;

public class SmsProviderFactory implements Provider {
    @Override
    public Sender proSender() {
        return new SmsSender();
    }
}
