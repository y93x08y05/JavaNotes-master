package com.jack.algorithm.设计模式.create.抽象工厂模式;

public class AsiaFactory implements AbstractFactory {
    @Override
    public Tiger createTiger() {
        return  new TigerAsia();
    }
    @Override
    public Dolphin createDolphin() {
        return new DolphinAsia();
    }
    @Override
    public Parrot createParrot() {
        return new ParrotAsia();
    }
}