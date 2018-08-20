package com.jack.basic.Other2;

/**
 * 静态域最先初始化，静态域包含静态变量、静态块和静态方法、
 * 初始化顺序依靠其位置决定
 * 用static声明的，JVM加载类时执行仅一次
 * 执行顺序：静态块>main>构造块>构造方法
 */
public class classLoader {
    public static classLoader a = new classLoader();
    public static classLoader b = new classLoader();
    {
        System.out.println("构造块");
    }
    static {
        System.out.println("静态块");
    }
    public static void main(String [] args) {
        classLoader c = new classLoader();
    }
}