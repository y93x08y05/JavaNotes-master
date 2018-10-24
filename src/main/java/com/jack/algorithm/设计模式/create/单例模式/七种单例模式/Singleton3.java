package com.jack.algorithm.设计模式.create.单例模式.七种单例模式;

/**
 * @Author: Jack
 * @Date: 2018/10/18 16:51
 * 基于ClassLoader机制避免了多线程的同步问题，instance在类装载时就实例化。
 * 导致类装载的原因有很多种，在单例模式中大多数都是调用getInstance方法。
 * 也可能有其他方式导致类装载，初始化instance即没有达到效果。
 */
public class Singleton3 {
    private static Singleton3 instance = new Singleton3();
    private Singleton3 (){}
    public static Singleton3 getInstance() {
        return instance;
    }
}