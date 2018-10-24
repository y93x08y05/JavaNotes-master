package com.jack.algorithm.设计模式.action.状态模式.example2;

public class Client {
    public static void main(String [] args){
        QQ qq = new QQ();
        qq.handle();
        qq.handle();
        qq.handle();
        qq.handle();
    }
}