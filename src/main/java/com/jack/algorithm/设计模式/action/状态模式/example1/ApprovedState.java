package com.jack.algorithm.设计模式.action.状态模式.example1;

public class ApprovedState implements State {
    @Override
    public void handle(Document document) {
        System.out.println("公文已结束");
    }
}