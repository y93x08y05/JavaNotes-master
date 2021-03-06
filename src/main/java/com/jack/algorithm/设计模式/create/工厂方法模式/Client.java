package com.jack.algorithm.设计模式.create.工厂方法模式;

public class Client {
    public static void main(String [] args){
        FactoryMethod factoryMethod = new TigerFactory();
        Animal animal = factoryMethod.createAnimal();
        animal.eat();
        FactoryMethod factoryMethod1 = new DolphinFactory();
        Animal animal1 = factoryMethod1.createAnimal();
        animal1.eat();
        FactoryMethod factoryMethod2 = new ParrotFactory();
        Animal animal2 = factoryMethod2.createAnimal();
        animal2.eat();
    }
}