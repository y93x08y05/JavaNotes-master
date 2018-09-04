package com.jack.designMode.action.State2018.example1;

public class SendOneChargeState implements State {
    @Override
    public void handle(Document document) {
        document.setState(new SendSuperChargeState());
        System.out.println("公文已发送一级主管");
    }
}