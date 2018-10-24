package com.jack.algorithm.设计模式.create.单例模式;

/**
 * 在单例模式中，调用类的实例，只能调用一个公共的接口
 * 实现单例模式的类在实例化之后不能被其他类继承，
 * 单例类很难实现序列化，
 * 在分布式系统中，当系统中的单例类被复制运行在多个虚拟机下，
 * 每一个虚拟机下都会创建一个实例对象，这种情况比较难知道哪个
 * 虚拟机运行着哪个单例对象
 */
public class Client {
    public static void main(String [] args){
        LogManager2018.log("设计模式从入门到精通");
        Singleton1.getInstance();
        Singleton2.getInstance();
    }
}