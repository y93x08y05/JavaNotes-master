package com.jack.algorithm.设计模式.create.建造者模式;

public class MotorcycleBuilder implements Builder{
    @Override
    public Carcase createCarcase() {
        return new Carcase1();
    }
    @Override
    public Engine createEngine() {
        return new Engine1();
    }
    @Override
    public Tyre createTyre() {
        return new Tyre1();
    }
    @Override
    public Wheel createWheel() {
        return  new Wheel1();
    }
}