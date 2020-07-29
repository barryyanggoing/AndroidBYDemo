package com.barryyang.barryyangdemo.java.model;

/**
 * @author : BarryYang
 * @date : 2020/7/29 11:11 AM
 * @desc :
 */
public class Student {

    private long userId;
    private String username;

    public Student(long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
