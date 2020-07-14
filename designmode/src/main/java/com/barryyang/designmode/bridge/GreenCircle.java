package com.barryyang.designmode.bridge;

public class GreenCircle implements DrawApi {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("画绿色的圆");
    }
}
