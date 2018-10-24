package com.jack.algorithm.设计模式.create.单例模式;

/**
 * 饿汉模式在类初始化的时候就创建自己的对象
 */
public class Singleton1 {
    private Singleton1(){

    }
    public static synchronized Singleton1 getInstance(){
        return instance;
    }
    private static Singleton1 instance = new Singleton1();
}