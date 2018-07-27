package com.Jack.CGLIB;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Jack on 7/24/2018 9:53 PM
 * Enhancer could proxy class and interface but JDK only could proxy interface
 * Enhancer could not interceptor final method and not proxy final class
 * because it achieve dynamics proxy through extends method
 */
public class Main1 {
    public static void main(String [] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Main1.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before method run...");
                Object result = methodProxy.invokeSuper(o,objects);
                System.out.println("after method run...");
                return result;
            }
        });
        Main1 main1 = (Main1) enhancer.create();
        main1.test();
    }
    public void test() {
        System.out.println("hello world");
    }
}
