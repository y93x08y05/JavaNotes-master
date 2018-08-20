package com.jack.designMode.create.FactoryMethod2018;

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