package com.jack.designMode.structure.Flyweight2018;

public class ShangFlyweight implements Flyweight{
    private String name;
    public ShangFlyweight(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}