package com.barryyang.barryyangdemo;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
//        reflection();
        // maopao(new int[]{2, 7, 3, 9, 20, 8});
//        xuanzhe(new int[]{2, 7, 3, 9, 20, 8});



        try {
            Class userClass = Class.forName("com.barryyang.barryyangdemo.ExampleUnitTest$User$Info");
            Field field2 = userClass.getDeclaredField("namessss");
//            Field modifiers = Field.class.getDeclaredField("modifiers");
//            field2.setAccessible(true);
//            Object getname=field2.get(null);
//            System.out.println("修改前"+getname);
//            modifiers.setInt("name", field2.getModifiers() & ~Modifier.FINAL);
//            field2.set(null, 1000);
//            System.out.println("修改后"+User.Info.name);
            Field modifiers = Field.class.getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(field2, field2.getModifiers() & ~Modifier.FINAL);
            field2.set(null, 520);
            Object getname=field2.get(null);
            System.out.println("修改后"+getname);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class User {

        private static class Info{
            public static final int namessss = 1200;
            public static final int namess = 1;
        }


    }

    /**
     * 选择排序
     *
     * @param array
     */
    private void xuanzhe(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        for (int j : array) {
            System.out.println(j);
        }
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    private void maopao(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int j : array) {
            System.out.println(j);
        }
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