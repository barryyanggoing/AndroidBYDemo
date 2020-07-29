package com.barryyang.barryyangdemo.designmodel.builder;

public abstract class Builder {
    public abstract void setPartName(String name);

    public abstract Product build();
}
