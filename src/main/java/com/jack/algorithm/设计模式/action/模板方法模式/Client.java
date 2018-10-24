package com.jack.algorithm.设计模式.action.模板方法模式;

/**
 * 模板方法模式就是定义一个算法执行的骨架，
 * 将具体的算法延迟到子类中实现
 * 使用模板方法模式可以自由实现具体的算法，但当算法的骨架改变时，
 * 需要修改抽象类
 */
public class Client {
    public static void main(String [] args){
        Report report = new ReportImpl();
        report.print();
        Report report1 = new ReportImpl1();
        report1.print();
    }
}