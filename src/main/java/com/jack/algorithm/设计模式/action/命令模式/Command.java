package com.jack.algorithm.设计模式.action.命令模式;

public abstract class Command {
    private Athlete athlete;
    public abstract void execute();

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }
}