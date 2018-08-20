package com.jack.designMode.action.ChainOfResponsibility.example1;

public abstract class Doctor {
    private Doctor doctor;
    public abstract void seeDoctor(Jack jack);

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}