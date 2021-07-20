package com.barryyang.barryyangdemo.android.process;

import java.io.Serializable;

/**
 * @author : BarryYang
 * @date : 2021/7/17 2:54 下午
 * @desc :
 */
public class User implements Serializable {

    private static final long serialiVsersionUID = 1L;

    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
