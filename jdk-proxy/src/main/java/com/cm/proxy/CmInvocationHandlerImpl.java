package com.cm.proxy;

import java.lang.reflect.Method;

public class CmInvocationHandlerImpl implements CmInvocationHandler {

    @Override
    public Object invoke(Method method) {
        System.out.println("+++++++++++动态代理逻辑++++++++++");
        return null;
    }

}
