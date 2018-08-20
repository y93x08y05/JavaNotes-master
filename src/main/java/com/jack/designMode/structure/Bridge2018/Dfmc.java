package com.jack.designMode.structure.Bridge2018;

public class Dfmc implements Manufacturer{

    @Override
    public void produce() {
        System.out.println("海外进口");
    }
}