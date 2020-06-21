package com.barryyang.designmode;

import android.util.Log;

public class MailSender implements Sender{
    @Override
    public void send() {
        Log.i("barryyang.send", "mail sms");
    }
}
