package com.jack.algorithm.设计模式.create.抽象工厂模式;

public class DophinAfrica extends Dolphin {
    @Override
    public void eat() {
        System.out.println("非洲海豚会吃");
    }
    @Override
    public void swim() {
        System.out.println("非洲海豚会游泳");
    }
}