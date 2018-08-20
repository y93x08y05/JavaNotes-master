package com.jack.designMode.structure.Bridge2018;

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