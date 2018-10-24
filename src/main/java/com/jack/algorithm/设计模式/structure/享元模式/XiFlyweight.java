package com.jack.algorithm.设计模式.structure.享元模式;

public class XiFlyweight implements Flyweight{
    private String name;
    public XiFlyweight(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}