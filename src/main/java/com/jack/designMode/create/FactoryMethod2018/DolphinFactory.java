package com.jack.designMode.create.FactoryMethod2018;

public class DolphinFactory implements FactoryMethod{
    @Override
    public Animal createAnimal() {
        return new Dolphin();
    }
}