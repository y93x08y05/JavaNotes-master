package com.jack.algorithm.设计模式.create.Singleton2018.七种单例模式;

/**
 * @Author: Jack
 * @Date: 2018/10/18 16:50
 */
public class Client {
    public static void main(String[] args) {
        Singleton1.getInstance();
        Singleton2.getInstance();
        Singleton3.getInstance();
        Singleton4.getInstance();
        Singleton5.getInstance();
        Singleton6.getInstance();
        Singleton7 instance = Singleton7.INSTANCE;
    }
}