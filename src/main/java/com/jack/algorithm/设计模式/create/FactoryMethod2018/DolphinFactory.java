package com.jack.algorithm.设计模式.create.FactoryMethod2018;

public class DolphinFactory implements FactoryMethod{
    @Override
    public Animal createAnimal() {
        return new Dolphin();
    }
}