package com.barryyang.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GamePlayIH implements InvocationHandler {

    //被代理者
    Class aClass;

    //被代理的实例
    Object object;

    //我要代理谁
    public GamePlayIH(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(this.object, args);
        if (method.getName().equals("login")) {
            System.out.println("有人用我的账号登录");
        }
        return invoke;
    }
}
