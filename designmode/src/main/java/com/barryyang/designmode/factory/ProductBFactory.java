package com.barryyang.designmode.factory;

public class ProductBFactory implements Factory {

    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
