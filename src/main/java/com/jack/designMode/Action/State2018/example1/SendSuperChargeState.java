package com.jack.designMode.action.State2018.example1;

public class SendSuperChargeState implements State {
    @Override
    public void handle(Document document) {
        document.setState(new ApprovedState());
        System.out.println("公文已审批完成");
    }
}