package com.barryyang.designmode.factory;

public class ProductAFactory implements Factory {

    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
