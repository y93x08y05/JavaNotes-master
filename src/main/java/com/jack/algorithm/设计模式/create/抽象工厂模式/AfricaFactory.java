package com.jack.algorithm.设计模式.create.抽象工厂模式;

public class AfricaFactory implements AbstractFactory {
    @Override
    public Tiger createTiger() {
        return new TigerAfrica();
    }
    @Override
    public Dolphin createDolphin() {
        return new DophinAfrica();
    }
    @Override
    public Parrot createParrot() {
        return new ParrotAfrica();
    }
}