package com.barryyang.barryyangdemo.main;

import java.io.Serializable;

/**
 * @author : BarryYang
 * @date : 2020/11/13 3:34 PM
 * @desc :
 */
public class PublishInfo implements Serializable {

    private int publishType;
    private String tabName;

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public int getPublishType() {
        return publishType;
    }

    public void setPublishType(int publishType) {
        this.publishType = publishType;
    }

    public PublishInfo(int publishType, String tabName) {
        this.publishType = publishType;
        this.tabName = tabName;
    }
}
