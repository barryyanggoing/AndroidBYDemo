package com.barryyang.designmode.lishitihuan;

public abstract class BaseView {

    public abstract void draw();

    public void measure(int width, int height) {
        System.out.println("measure");
    }
}
