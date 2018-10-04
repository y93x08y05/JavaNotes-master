package com.jack.algorithm.设计模式.action.ChainOfResponsibility.example1;

public class AssimilationDoctor extends Doctor {
    @Override
    public void seeDoctor(Jack jack) {
        if (jack.getStomach().booleanValue()) {
            System.out.println("消化科的医生看病");
        } else {
            super.getDoctor().seeDoctor(jack);
        }
    }
}