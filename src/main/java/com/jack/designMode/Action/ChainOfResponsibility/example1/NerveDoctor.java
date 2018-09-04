package com.jack.designMode.action.ChainOfResponsibility.example1;

public class NerveDoctor extends Doctor {
    @Override
    public void seeDoctor(Jack jack) {
        if (jack.getHead().booleanValue()){
            System.out.println("神经科的医生看病");
        } else if (super.getDoctor() != null){
            super.getDoctor().seeDoctor(jack);
        }
    }
}