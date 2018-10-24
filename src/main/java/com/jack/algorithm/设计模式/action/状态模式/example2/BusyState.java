package com.jack.algorithm.设计模式.action.状态模式.example2;

public class BusyState implements QQState {
    @Override
    public void handle(QQ qq) {
        qq.setState(new LeaveState());
        System.out.println("QQ已离线");
    }
}