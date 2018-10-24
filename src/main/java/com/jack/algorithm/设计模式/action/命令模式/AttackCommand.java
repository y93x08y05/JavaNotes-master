package com.jack.algorithm.设计模式.action.命令模式;

public class AttackCommand extends Command{
    @Override
    public void execute() {
        super.getAthlete().attack();
    }
}