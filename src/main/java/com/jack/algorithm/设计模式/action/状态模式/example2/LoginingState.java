package com.jack.algorithm.设计模式.action.状态模式.example2;

public class LoginingState implements QQState {
    @Override
    public void handle(QQ qq) {
        qq.setState(new LiningState());
        System.out.println("QQ已在线");
    }
}