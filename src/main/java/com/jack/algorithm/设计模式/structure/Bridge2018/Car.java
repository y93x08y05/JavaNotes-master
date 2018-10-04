package com.jack.algorithm.设计模式.structure.Bridge2018;

public abstract class Car {

    Manufacturer manufacturer;

    public Car(Manufacturer manufacturer){
        this.manufacturer = manufacturer;
    }

    public void produce(){
        manufacturer.produce();
    }
}