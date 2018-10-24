package com.jack.algorithm.设计模式.create.抽象工厂模式;

public class Parrot implements Animal {
    @Override
    public void eat() {
        System.out.println("鹦鹉会吃");
    }
    public void fly(){
        System.out.println("鹦鹉会飞");
    }
}