package com.barryyang.barryyangdemo.designmodel.abstract_factory;

public abstract class AbstractFactory {

    public abstract Shape getShape(String shapeType);

    public abstract Color getColor(String colorType);
}
