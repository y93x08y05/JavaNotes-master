package com.jack.designMode.structure.Flyweight2018;

public class XueFlyweight implements Flyweight{
    private String name;
    public XueFlyweight(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}