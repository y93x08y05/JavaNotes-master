package com.jack.algorithm.设计模式.structure.桥接模式;

public class Bus extends Car{

    public Bus(Manufacturer manufacturer){
        super(manufacturer);
    }

    @Override
    public void produce() {
        manufacturer.produce();
        System.out.println("公共汽车");
    }
}