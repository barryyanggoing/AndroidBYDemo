package com.barryyang.barryyangdemo.java.model;

import android.os.Build;

import java.util.Objects;

/**
 * @author : BarryYang
 * @date : 2020/7/29 11:20 AM
 * @desc :
 */
public class Person {

    private long userId;
    private String username;

    public Person(long userId, String username) {
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

    @Override
    public boolean equals(Object object) {
        if (object instanceof Person) {
            Person person = (Person) object;
            return userId == person.userId && username.equalsIgnoreCase(person.username);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return Objects.hash(userId, username);
        }
        return Long.valueOf(userId).hashCode() + username.hashCode();
    }
}
