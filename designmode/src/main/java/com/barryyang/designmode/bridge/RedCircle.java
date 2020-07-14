package com.barryyang.designmode.bridge;

public class RedCircle implements DrawApi {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("画红色的圆");
    }
}
