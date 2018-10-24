package com.jack.algorithm.设计模式.structure.享元模式;

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