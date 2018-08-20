package com.jack.designMode.create.AbstractFactory2018;

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