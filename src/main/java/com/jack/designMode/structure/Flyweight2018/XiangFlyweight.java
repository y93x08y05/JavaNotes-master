package com.jack.designMode.structure.Flyweight2018;

public class XiangFlyweight implements Flyweight{
    private String name;
    public XiangFlyweight(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}