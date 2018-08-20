package com.jack.designMode.action.State2018.example2;

public class LeaveState implements QQState{
    @Override
    public void handle(QQ qq) {
        qq.setState(new LoginingState());
        System.out.println("QQ正在登录");
    }
}