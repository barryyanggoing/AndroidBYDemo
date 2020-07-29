package com.barryyang.barryyangdemo.designmodel.interceptor;

public class DebugInterceptor implements DefaultInterceptor {

    @Override
    public void interceptor(String type, InterceptorCallBack interceptorCallBack) {
        if (type.equalsIgnoreCase("debug")) {
            interceptorCallBack.onFailed();
        }
    }
}
