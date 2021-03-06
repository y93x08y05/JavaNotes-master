package com.jack.algorithm.设计模式.create.抽象工厂模式;

public class Client {
    public static void main(String [] args){
        AbstractFactory abstractFactory = new AsiaFactory();
        Tiger tiger = abstractFactory.createTiger();
        tiger.eat();
        Dolphin dolphin = abstractFactory.createDolphin();
        dolphin.eat();
        Parrot parrot = abstractFactory.createParrot();
        parrot.eat();
        AbstractFactory abstractFactory1 = new AfricaFactory();
        Tiger tiger1 = abstractFactory1.createTiger();
        tiger1.eat();
        Dolphin dolphin1 = abstractFactory1.createDolphin();
        dolphin1.eat();
        Parrot parrot1 = abstractFactory1.createParrot();
        parrot1.eat();
    }
}