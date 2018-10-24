package com.jack.algorithm.设计模式.action.模板方法模式;

public abstract class Report {
    public void print(){
        printTitle();
        printBody();
        printTail();
    }
    public abstract void printTitle();
    public abstract void printBody();
    public abstract void printTail();

}