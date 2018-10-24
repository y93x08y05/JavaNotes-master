package com.jack.algorithm.设计模式.create.单例模式.七种单例模式;

/**
 * @Author: Jack
 * @Date: 2018/10/18 16:46
 * 懒汉，线程安全。
 * 多线程中可以正常工作，但是效率比较低，99%情况下不需要同步。
 */
public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2 (){}
    public static synchronized Singleton2 getInstance() {
        if (instance == null)
            instance = new Singleton2();
        return instance;
    }
}