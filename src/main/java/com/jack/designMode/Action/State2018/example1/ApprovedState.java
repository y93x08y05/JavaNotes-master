package com.jack.designMode.action.State2018.example1;

public class ApprovedState implements State {
    @Override
    public void handle(Document document) {
        System.out.println("公文已结束");
    }
}