package com.jack.algorithm.设计模式.create.单例模式;

/**
 * 懒汉单例模式在需要使用的时候才创建自身的对象
 */
public class Singleton2 {
    private static Singleton2 instance = null;
    public static synchronized Singleton2 getInstance(){
        if (instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}