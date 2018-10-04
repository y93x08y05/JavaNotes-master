package com.jack.algorithm.设计模式.create.Singleton2018;

/**
 * 饿汉模式在类初始化的时候就创建自己的对象
 */
public class Singleton1 {
    protected Singleton1(){

    }
    public static Singleton1 getInstance(){
        return instance;
    }
    private static Singleton1 instance = new Singleton1();
}