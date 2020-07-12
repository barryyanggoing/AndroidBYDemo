package com.barryyang.designmode.abstract_factory;

public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        if ("white".equalsIgnoreCase(colorType)) {
            return new WhiteColor();
        } else if ("black".equalsIgnoreCase(colorType)) {
            return new BlackColor();
        }
        return null;
    }
}
