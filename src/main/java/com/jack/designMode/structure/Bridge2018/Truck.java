package com.jack.designMode.structure.Bridge2018;

public class Truck extends Car{

    public Truck(Manufacturer manufacturer){
        super(manufacturer);
    }

    @Override
    public void produce() {
        manufacturer.produce();
        System.out.println("货车");
    }
}