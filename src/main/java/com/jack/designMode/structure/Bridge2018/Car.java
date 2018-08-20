package com.jack.designMode.structure.Bridge2018;

public abstract class Car {

    Manufacturer manufacturer;

    public Car(Manufacturer manufacturer){
        this.manufacturer = manufacturer;
    }

    public void produce(){
        manufacturer.produce();
    }
}