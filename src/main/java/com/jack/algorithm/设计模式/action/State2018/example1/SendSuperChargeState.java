package com.jack.algorithm.设计模式.action.State2018.example1;

public class SendSuperChargeState implements State {
    @Override
    public void handle(Document document) {
        document.setState(new ApprovedState());
        System.out.println("公文已审批完成");
    }
}