package com.jack.designMode.action.State2018.example2;

public class LoginingState implements QQState {
    @Override
    public void handle(QQ qq) {
        qq.setState(new LiningState());
        System.out.println("QQ已在线");
    }
}