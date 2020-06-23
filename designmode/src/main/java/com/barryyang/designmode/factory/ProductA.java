package com.barryyang.designmode.factory;

public class ProductA implements Product {

    @Override
    public void createName() {
        System.out.println("ProductA");
    }
}
