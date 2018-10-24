package com.jack.algorithm.设计模式.action.状态模式.example2;

public class LeaveState implements QQState{
    @Override
    public void handle(QQ qq) {
        qq.setState(new LoginingState());
        System.out.println("QQ正在登录");
    }
}