package com.barryyang.designmode;

public class MailProviderFactory implements Provider{
    @Override
    public Sender proSender() {
        return new MailSender();
    }
}
