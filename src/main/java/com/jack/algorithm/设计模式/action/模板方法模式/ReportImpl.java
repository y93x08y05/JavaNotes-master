package com.jack.algorithm.设计模式.action.模板方法模式;

public class ReportImpl extends Report{
    @Override
    public void printTitle() {
        System.out.println("采用一种方式打印表头");
    }

    @Override
    public void printBody() {
        System.out.println("采用一种方式打印正文");
    }

    @Override
    public void printTail() {
        System.out.println("采用一种方法打印表尾");
    }
}