package com.barryyang.barryyangdemo.java.reflection;

/**
 * @author : BarryYang
 * @date : 2021/6/22 3:45 下午
 * @desc :
 */
public class Student {

    private int age;
    public String userName;

    public Student() {

    }

    private Student(String userName) {
        this.userName = userName;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private String show(String message) {
        System.out.println("userName = " + userName + ",age = " + age + ",message = " + message);
        return "finish";
    }

}
