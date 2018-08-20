package com.jack.designMode.create.AbstractFactory2018;

public class Parrot implements Animal {
    @Override
    public void eat() {
        System.out.println("鹦鹉会吃");
    }
    public void fly(){
        System.out.println("鹦鹉会飞");
    }
}