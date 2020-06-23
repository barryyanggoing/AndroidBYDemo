package com.barryyang.designmode.factory;

public class ProductB implements Product {

    @Override
    public void createName() {
        System.out.println("ProductB");
    }
}
