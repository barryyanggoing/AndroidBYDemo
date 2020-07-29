package com.barryyang.barryyangdemo.designmodel.abstract_factory;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        if ("cirlce".equalsIgnoreCase(shapeType)) {
            return new CircleShape();
        } else if ("rect".equalsIgnoreCase(shapeType)) {
            return new RectShape();
        }
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
