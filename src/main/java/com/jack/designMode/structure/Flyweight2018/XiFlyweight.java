package com.jack.designMode.structure.Flyweight2018;

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