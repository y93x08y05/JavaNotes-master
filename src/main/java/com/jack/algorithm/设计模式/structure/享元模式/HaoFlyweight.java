package com.jack.algorithm.设计模式.structure.享元模式;

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