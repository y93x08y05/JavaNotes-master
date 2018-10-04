package com.jack.algorithm.设计模式.structure.Flyweight2018;

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