package com.jack.algorithm.设计模式.action.状态模式.example1;

public class CreatedState implements State {
    @Override
    public void handle(Document document) {
        document.setState(new SendOneChargeState());
        System.out.println("公文已发送二级主管");
    }
}