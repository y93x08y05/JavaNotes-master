package com.jack.designMode.action.Command2018;

public class AttackCommand extends Command{
    @Override
    public void execute() {
        super.getAthlete().attack();
    }
}