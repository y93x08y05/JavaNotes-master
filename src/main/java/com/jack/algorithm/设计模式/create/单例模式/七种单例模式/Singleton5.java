package com.jack.algorithm.设计模式.create.单例模式.七种单例模式;

/**
 * @Author: Jack
 * @Date: 2018/10/18 19:28
 * 利用ClassLoader机制保证初始化instance时只有一个线程。
 * Singleton3和Singleton4是只要类被装载了，就会实例化instance。
 * Singleton5类被装载了，instance不一定被初始化。
 * 因为SingletonHolder类没有被主动使用，只有显式调用getInstance方法
 * 才会装载SingletonHolder类，从而实例化instance。
 * 如果实例化instance很消耗资源，想延迟加载，并且不希望在Singleton5
 * 类加载时就实例化，因为不能确保Singleton类还可能在其他地方被
 * 主动使用从而被加载，这个时候实例化instance不合适。
 * 则Singleton5比Singleton3和Singleton4更合理。
 */
public class Singleton5 {
    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }
    private Singleton5 (){}
    public static final Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}