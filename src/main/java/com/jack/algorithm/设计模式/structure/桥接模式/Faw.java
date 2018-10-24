package com.jack.algorithm.设计模式.structure.桥接模式;

public class Faw implements Manufacturer{

    @Override
    public void produce() {
        System.out.println("一汽制造");
    }
}