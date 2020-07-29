package com.barryyang.barryyangdemo.designmodel.interceptor;

public class ReleaseInterceptor implements DefaultInterceptor {

    @Override
    public void interceptor(String type, InterceptorCallBack interceptorCallBack) {
        if (type.equalsIgnoreCase("release")) {
            interceptorCallBack.onSuccess();
        }
    }
}
