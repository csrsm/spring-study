package com.cm.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerUtils implements InvocationHandler {

    private Object target;
     public InvocationHandlerUtils(Object target) {
        this.target = target;
     }

    /**
     *
     * @param proxy 代理对象
     * @param method 目标对象、目标方法
     * @param args 目标方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("---------AOP Proxy InvocationHandler--------");

        return method.invoke(target,args);
    }

}
