package com.jack.algorithm.设计模式.action.状态模式.example2;

public class LiningState implements QQState {
    @Override
    public void handle(QQ qq) {
        qq.setState(new BusyState());
        System.out.println("QQ忙碌中");
    }
}