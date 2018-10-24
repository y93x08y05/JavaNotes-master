package com.jack.algorithm.设计模式.create.抽象工厂模式;

public class TigerAsia extends Tiger {
    @Override
    public void eat() {
        System.out.println("亚洲虎会吃");
    }
    @Override
    public void run() {
        System.out.println("亚洲虎会跑");
    }
}