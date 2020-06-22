package com.barryyang.barryyangdemo;

import java.io.Serializable;

public class ItemInfo implements Serializable {

    public int viewType;
    public String name;

    public ItemInfo(int viewType, String name) {
        this.viewType = viewType;
        this.name = name;
    }

}
