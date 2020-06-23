package com.barryyang.designmode.dimite;

import java.util.Random;

public class Wizard {

    private Random random = new Random(System.currentTimeMillis());

    private int first() {
        System.out.println("first执行");
        return random.nextInt(100);
    }

    private int second() {
        System.out.println("second执行");
        return random.nextInt(100);
    }

    private int third() {
        System.out.println("third执行");
        return random.nextInt(100);
    }

    public void installWizard() {
        int first = first();
        if (first > 50) {
            int second = second();
            if (second > 50) {
                int third = third();
                if (third > 50) {
                    first();
                }
            }
        }
    }
}
