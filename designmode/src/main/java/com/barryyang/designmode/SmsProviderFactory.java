package com.barryyang.designmode;

public class SmsProviderFactory implements Provider {
    @Override
    public Sender proSender() {
        return new SmsSender();
    }
}
