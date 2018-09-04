package com.jack.designMode.action.Command2018;

public class DefenseCommand extends Command{
    @Override
    public void execute() {
        super.getAthlete().defense();
    }
}