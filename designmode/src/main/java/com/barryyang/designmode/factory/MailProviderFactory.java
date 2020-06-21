package com.barryyang.designmode.factory;

public class MailProviderFactory implements Provider{
    @Override
    public Sender proSender() {
        return new MailSender();
    }
}
