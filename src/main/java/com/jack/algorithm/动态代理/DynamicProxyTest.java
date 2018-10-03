package com.jack.algorithm.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Jack
 * @Date: 2018/10/3 21:14
 */
public class DynamicProxyTest implements InvocationHandler {
    private Target target;
    private DynamicProxyTest(Target target) {
        this.target=target;
    }
    public static Target newProxyInstance(Target target) {
        return (Target) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(),
                new Class<?>[]{Target.class},
                new DynamicProxyTest(target));
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }
}