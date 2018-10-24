package com.jack.algorithm.设计模式.create.抽象工厂模式;

public class ParrotAsia extends Parrot {
    @Override
    public void eat() {
        System.out.println("亚洲鹦鹉会吃");
    }
    @Override
    public void fly() {
        System.out.println("亚洲鹦鹉会飞");
    }
}