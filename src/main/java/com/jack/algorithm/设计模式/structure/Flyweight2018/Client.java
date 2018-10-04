package com.jack.algorithm.设计模式.structure.Flyweight2018;

/**
 * 使用享元模式设计频繁使用，又需要占用大量内存的对象
 * 享元模式主要由享元类，具体的享元类，享元工厂类组成。
 * 其可以为系统节省大量的空间，其是典型的用时间换空间
 * 如果要维护的享元很多，则在查找的过程中要消耗大量的时间。
 */
public class Client {
    public static void main(String [] args){
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight flyweight1 = flyweightFactory.getFlyweight("好");
        Flyweight flyweight2 = flyweightFactory.getFlyweight("好");
        Flyweight flyweight3 = flyweightFactory.getFlyweight("学");
        Flyweight flyweight4 = flyweightFactory.getFlyweight("习");
        Flyweight flyweight = flyweightFactory.getFlyweight("，");
        Flyweight flyweight5 = flyweightFactory.getFlyweight("天");
        Flyweight flyweight6 = flyweightFactory.getFlyweight("天");
        Flyweight flyweight7 = flyweightFactory.getFlyweight("向");
        Flyweight flyweight8 = flyweightFactory.getFlyweight("上");
        System.out.println(flyweight1.getName()+flyweight2.getName()+flyweight3.getName()+
            flyweight4.getName()+flyweight.getName()+flyweight5.getName()+flyweight6.getName()+
            flyweight7.getName()+flyweight8.getName());

        flyweight1 = flyweightFactory.getFlyweight("好");
        flyweight2 = flyweightFactory.getFlyweight("好");
        flyweight3 = flyweightFactory.getFlyweight("学");
        flyweight4 = flyweightFactory.getFlyweight("习");
        flyweight = flyweightFactory.getFlyweight("，");
        flyweight5 = flyweightFactory.getFlyweight("天");
        flyweight6 = flyweightFactory.getFlyweight("天");
        flyweight7 = flyweightFactory.getFlyweight("向");
        flyweight8 = flyweightFactory.getFlyweight("上");
        System.out.println(flyweight1.getName()+flyweight2.getName()+flyweight3.getName()+
                flyweight4.getName()+flyweight.getName()+flyweight5.getName()+flyweight6.getName()+
                flyweight7.getName()+flyweight8.getName());

    }
}