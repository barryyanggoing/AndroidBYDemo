package com.barryyang.thread;

import com.barryyang.thread.interruptThread.PrintString;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        PrintString printString = new PrintString();
        new Thread(printString).start();
        System.out.println("我要停止他");
        printString.setContinuePrint(false);
    }
}