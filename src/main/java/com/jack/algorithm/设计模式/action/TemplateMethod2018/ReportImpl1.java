package com.jack.algorithm.设计模式.action.TemplateMethod2018;

public class ReportImpl1 extends Report {
    @Override
    public void printTitle() {
        System.out.println("采用另外一种方式打印表头");
    }

    @Override
    public void printBody() {
        System.out.println("采用另外一种方式打印正文");
    }

    @Override
    public void printTail() {
        System.out.println("采用另外一种方式打印表尾");
    }
}