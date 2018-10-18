package com.jack.algorithm.设计模式.create.Singleton2018.七种单例模式;

/**
 * @Author: Jack
 * @Date: 2018/10/18 19:18
 */
public class Singleton4 {
    private static Singleton4 instance;
    static {
        instance = new Singleton4();
    }
    private Singleton4 (){}
    public static Singleton4 getInstance() {
        return instance;
    }
}