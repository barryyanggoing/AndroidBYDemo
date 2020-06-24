package com.barryyang.designmode.builder;

public class ProductBuilder extends Builder {

    final Product product = new Product();

    @Override
    public void setPartName(String name) {
        product.name = name;
    }

    @Override
    public Product build() {
        return product;
    }
}
