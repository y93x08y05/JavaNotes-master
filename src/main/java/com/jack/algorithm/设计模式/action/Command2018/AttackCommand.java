package com.jack.algorithm.设计模式.action.Command2018;

public class AttackCommand extends Command{
    @Override
    public void execute() {
        super.getAthlete().attack();
    }
}