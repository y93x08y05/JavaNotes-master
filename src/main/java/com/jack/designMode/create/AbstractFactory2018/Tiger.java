package com.jack.designMode.create.AbstractFactory2018;

public class Tiger implements Animal{
    @Override
    public void eat() {
        System.out.println("老虎会吃");
    }
    public void run(){
        System.out.println("老虎会跑");
    }
}