package com.jack.algorithm.设计模式.create.Singleton2018.七种单例模式;

/**
 * @Author: Jack
 * @Date: 2018/10/18 19:43
 * 枚举类是在JDK1.5才出现的
 * 枚举类Enumeration是个抽象类，一旦一个类声明为枚举，实际上继承了
 * Enum，会有String.class和int.class的构造器。
 * 枚举类可以避免反射攻击和序列化问题。
 * 单例模式三个特点：
 * （1）构造方法私有化。
 * （2）实例化的变量引用私有化。
 * （3）获得实例的方法共有。
 */
public enum Singleton7 {
    INSTANCE;
    /*
     * Enum是Java提供给编译器的一个用于继承的类
     * 枚举量的实现都是public static final T类型的未初始化变量
     * 每一个枚举类型和枚举变量在JVM中都是唯一的
     */
    public Singleton7 getInstance() {
        return INSTANCE;
    }
}
