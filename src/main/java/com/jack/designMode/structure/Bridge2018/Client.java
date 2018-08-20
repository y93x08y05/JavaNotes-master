package com.jack.designMode.structure.Bridge2018;

/**
 * 桥模式就是将抽象与实现解耦，使得分别独立变化，为替代继承
 * 桥模式由抽象类，抽象类的继承类，实现类，实现类的继承类组成
 * 当系统需要在抽象和实现之间增加更多的灵活性，或者
 * 一个对象有多于一个的抽象和实现时，则使用桥模式
 */
public class Client {
    public static void main(String [] args) {
        Car car = new Truck(new Faw());
        car.produce();
    }
}