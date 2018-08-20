package com.jack.algorithm.OOMGC;

/**
 * 动态代理实现在原始类和接口为止时，就确定代理类的行为
 * 当代理类与原始类脱离直接联系后，可重用于不同的应用场景中
 * 代理类的逻辑是在在原始类方法执行前打印welcome
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    interface IHello {
        void sayHello();
    }
    static class Hello implements IHello {
        @Override
        public void sayHello(){
            System.out.println("hello , world");
        }
    }
    static class DynamicProxy implements InvocationHandler{
        Object originalObj;
        Object bind(Object originalObj){
            this.originalObj = originalObj;
            return
                    Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),
                            originalObj.getClass().getInterfaces(),
                            this);
        }
        @Override
        public Object invoke(Object proxy , Method method , Object [] args)
            throws Throwable{
            System.out.println("welcome");
            return method.invoke(originalObj,args);
        }
    }
    public static void main(String [] args){
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);
    }
}