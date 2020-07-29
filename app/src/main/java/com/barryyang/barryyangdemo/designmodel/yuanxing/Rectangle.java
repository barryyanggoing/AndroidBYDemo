package com.barryyang.barryyangdemo.designmodel.yuanxing;

public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Rectangle");
    }
}
