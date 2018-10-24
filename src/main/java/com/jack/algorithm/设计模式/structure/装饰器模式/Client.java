package com.jack.algorithm.设计模式.structure.装饰器模式;

/**
 * 装饰模式是使用被装饰类的一个子类的实例，在客户端将这个子类的实例委托给
 * 装饰类，是继承关系的一个替代方案。
 * 装饰模式主要由抽象的被装饰类，具体的被装饰类，抽象的装饰类，具体的装饰类组成
 * 使用装饰模式能够提供比使用继承关系更灵活的扩展对象的功能，可以动态地增加对象
 * 的功能，并且可以随意的组合这些功能。
 */
public class Client {
    public static void main(String [] args) {
        Phone phone  = new PhoneImpl();
        PhoneDecorator phoneDecorator = new AdPhoneDecorator(new ColorPhoneDecorator(phone));
        phoneDecorator.call("张三");
    }
}