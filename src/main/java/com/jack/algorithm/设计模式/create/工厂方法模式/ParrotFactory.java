package com.jack.algorithm.设计模式.create.工厂方法模式;

public class ParrotFactory implements FactoryMethod {
    @Override
    public Animal createAnimal() {
        return new Parrot();
    }
}