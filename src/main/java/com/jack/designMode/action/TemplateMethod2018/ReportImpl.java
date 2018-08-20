package com.jack.designMode.action.TemplateMethod2018;

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