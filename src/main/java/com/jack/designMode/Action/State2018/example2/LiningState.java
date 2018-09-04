package com.jack.designMode.action.State2018.example2;

public class LiningState implements QQState {
    @Override
    public void handle(QQ qq) {
        qq.setState(new BusyState());
        System.out.println("QQ忙碌中");
    }
}