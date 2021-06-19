package com.barryyang.barryyangdemo.java.fanshe;

/**
 * @author : BarryYang
 * @date : 2021/6/15 6:39 下午
 * @desc :
 */
public class Persion {

    public void print() {
        System.out.println("i am Outer class");
    }

    class InnerClass {
        void print2() {
            System.out.println("i am inner class");
        }
    }

}
