package com.jack.designMode.structure.Flyweight2018;

public class HaoFlyweight implements Flyweight{
    private String name;
    public HaoFlyweight(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}