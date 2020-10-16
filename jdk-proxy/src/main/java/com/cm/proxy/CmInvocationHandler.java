package com.cm.proxy;

import java.lang.reflect.Method;

public interface CmInvocationHandler {

    public Object invoke(Method method);

}
