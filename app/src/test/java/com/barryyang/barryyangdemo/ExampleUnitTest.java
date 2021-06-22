package com.barryyang.barryyangdemo;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        reflection();
    }

    /**
     * Java反射
     */
    private void reflection() {
        try {
            Class<?> aClass = Class.forName("com.barryyang.barryyangdemo.java.reflection.Student");
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
            declaredConstructor.setAccessible(true);
            Object o = declaredConstructor.newInstance("BarryYang");
            Field declaredField = aClass.getDeclaredField("age");
            declaredField.setAccessible(true);
            declaredField.set(o, 10);

            Method show = aClass.getDeclaredMethod("show", String.class);
            show.setAccessible(true);
            Object invoke = show.invoke(o, "hello world");
            System.out.println(invoke);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}