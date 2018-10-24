package com.jack.algorithm.设计模式.create.抽象工厂模式;

public class ParrotAfrica extends Parrot{
    @Override
    public void eat() {
        System.out.println("非洲鹦鹉会吃");
    }
    @Override
    public void fly() {
        System.out.println("非洲鹦鹉会飞");
    }
}