package com.barryyang.barryyangdemo.designmodel.yuanxing;

public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Circle");
    }
}
