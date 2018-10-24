package com.jack.algorithm.设计模式.action.状态模式.example2;

public class QQ {
    public QQ(){
        state = new LeaveState();
    }
    private QQState state;

    public QQState getState() {
        return state;
    }

    public void setState(QQState state) {
        this.state = state;
    }

    public void handle(){
        state.handle(this);
    }
}