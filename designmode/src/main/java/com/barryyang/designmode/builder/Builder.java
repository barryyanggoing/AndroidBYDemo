package com.barryyang.designmode.builder;

public abstract class Builder {
    public abstract void setPartName(String name);

    public abstract Product build();
}
