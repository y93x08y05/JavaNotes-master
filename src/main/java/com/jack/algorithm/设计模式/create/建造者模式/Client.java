package com.jack.algorithm.设计模式.create.建造者模式;

public class Client {
    public static void main(String [] args){
        Director director = new Director(new MotorcycleBuilder());
        director.assembleMotorcycle();
    }
}