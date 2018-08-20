package com.jack.designMode.structure.Flyweight2018;

public class InterFlyweight implements Flyweight{
    private String name;
    public InterFlyweight(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}