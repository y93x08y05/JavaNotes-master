package com.jack.algorithm.概览.动态代理;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: Jack
 * @Date: 2018/10/3 21:18
 */
public class CglibProxyTest implements MethodInterceptor {
    private CglibProxyTest() {

    }
    public static <T extends Target> Target newProxyInstance(Class<T> targetInstanceClazz) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(targetInstanceClazz);
        enhancer.setCallback(new CglibProxyTest());
        return (Target) enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}