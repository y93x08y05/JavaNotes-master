package com.jack.designMode.action.Observer2018.example2;

/**
 * 观察者模式在被观察者和观察者之间建立一种抽象的耦合，
 * 每一个具体观察者都符合一个抽象观察者的接口，
 * 被观察者并不知道一个具体的观察者，只知道他们有一个共同的接口，
 * 从而使得观察者和被观察者的耦合度降低，而且观察者模式支持广播通信，
 * 被观察者会向所有的注册过的观察者发出通知。
 * 缺点：如果一个被观察者对象有多个观察者，通知所有的观察者会耗费很多时间。
 * 观察者模式使用：
 * （1）当对一个对象的改变需要同时改变其他对象的，而不知道具体有多少对象需要改变
 * （2）当一个对象必须通知其他对象，而又不能假定其他对象是谁的时候
 */
public class Client {
    public static void main(String [] args){
        Stock stock = new Stock();
        stock.add(new PhoneClient());
        stock.add(new ComputerClient());
        stock.changePrice();
        stock.changeCount();
    }
}