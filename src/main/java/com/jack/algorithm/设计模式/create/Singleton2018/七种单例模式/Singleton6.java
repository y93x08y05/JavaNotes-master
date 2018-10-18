package com.jack.algorithm.设计模式.create.Singleton2018.七种单例模式;

/**
 * @Author: Jack
 * @Date: 2018/10/18 19:58
 * 双重校验锁
 */
public class Singleton6 {
    private volatile static Singleton6 instance;
    private Singleton6 (){}
    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null)
                    instance = new Singleton6();
            }
        }
        return instance;
    }
}