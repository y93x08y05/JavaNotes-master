package com.jack.designMode.action.ChainOfResponsibility.example1;

public class SleepDoctor extends Doctor {
    @Override
    public void seeDoctor(Jack jack) {
        if (jack.getSleep().booleanValue()) {
            System.out.println("睡眠中心的医生看病");
        } else {
            super.getDoctor().seeDoctor(jack);
        }
    }
}