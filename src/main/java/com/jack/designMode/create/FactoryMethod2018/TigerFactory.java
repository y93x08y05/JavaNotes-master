package com.jack.designMode.create.FactoryMethod2018;

public class TigerFactory implements FactoryMethod{
    @Override
    public Animal createAnimal() {
        return new Tiger();
    }
}