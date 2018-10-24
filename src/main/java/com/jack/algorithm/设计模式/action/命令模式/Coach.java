package com.jack.algorithm.设计模式.action.命令模式;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private Command attackCommand;
    private Command defenseCommand;
    List list = new ArrayList();
    public Coach(AttackCommand attackCommand,DefenseCommand defenseCommand) {
        this.attackCommand = attackCommand;
        this.defenseCommand = defenseCommand;
    }
    public void attack(){
        attackCommand.execute();
        list.add(attackCommand);
    }
    public void defense(){
        defenseCommand.execute();
        list.add(defenseCommand);
    }
    public void rebroadcast(){
        for (int i=0;i<list.size();i++){
            Command command = (Command)list.get(i);
            command.execute();
        }
    }
}