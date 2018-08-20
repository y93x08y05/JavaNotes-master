package com.jack.designMode.create.FactoryMethod2018;

public class ParrotFactory implements FactoryMethod {
    @Override
    public Animal createAnimal() {
        return new Parrot();
    }
}