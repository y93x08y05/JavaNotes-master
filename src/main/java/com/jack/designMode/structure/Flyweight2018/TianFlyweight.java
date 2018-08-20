package com.jack.designMode.structure.Flyweight2018;

public class TianFlyweight implements Flyweight{
    private String name;
    public TianFlyweight(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}