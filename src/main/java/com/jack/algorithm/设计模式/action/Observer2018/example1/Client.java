package com.jack.algorithm.设计模式.action.Observer2018.example1;

/**
 * 在Java中实现观察者模式，使用Observable类和Observer接口
 * 被观察者继承Observable类，观察者实现Observer接口
 */
public class Client {
    public static void main(String [] args){
        Stock stock = new Stock();
        stock.addObserver(new PhoneClient());
        stock.addObserver(new ComputerClient());
        stock.changeCountAndPrice();
    }
}