package com.jack.designMode.action.State2018.example2;

public class BusyState implements QQState {
    @Override
    public void handle(QQ qq) {
        qq.setState(new LeaveState());
        System.out.println("QQ已离线");
    }
}