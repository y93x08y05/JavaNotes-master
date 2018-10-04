package com.jack.algorithm.设计模式.create.AbstractFactory2018;

public class Dolphin implements Animal {
    @Override
    public void eat() {
        System.out.println("海豚会吃");
    }
    public void swim(){
        System.out.println("海豚会游泳");
    }
}