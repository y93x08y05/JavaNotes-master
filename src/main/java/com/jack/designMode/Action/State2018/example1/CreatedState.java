package com.jack.designMode.action.State2018.example1;

public class CreatedState implements State {
    @Override
    public void handle(Document document) {
        document.setState(new SendOneChargeState());
        System.out.println("公文已发送二级主管");
    }
}