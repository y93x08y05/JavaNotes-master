package com.jack.algorithm.设计模式.create.Singleton2018.七种单例模式;

/**
 * @Author: Jack
 * @Date: 2018/10/18 16:43
 * 懒汉，线程不安全。
 * 多线程下不能正常工作。
 */
public class Singleton1 {
    private static Singleton1 instance;
    private Singleton1 (){}
    public static Singleton1 getInstance() {
        if (instance == null)
            instance = new Singleton1();
        return instance;
    }
}