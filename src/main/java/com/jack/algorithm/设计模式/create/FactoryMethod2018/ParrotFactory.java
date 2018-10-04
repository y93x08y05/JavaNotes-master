package com.jack.algorithm.设计模式.create.FactoryMethod2018;

public class ParrotFactory implements FactoryMethod {
    @Override
    public Animal createAnimal() {
        return new Parrot();
    }
}