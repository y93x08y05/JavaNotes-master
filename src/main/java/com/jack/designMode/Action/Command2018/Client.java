package com.jack.designMode.action.Command2018;

/**
 * 命令模式就是把一个请求或者操作封装到一个对象中
 * 命令模式允许系统使用不同的请求把客户端参数化。
 * 对请求排队或者记录请求日志，可以方便地实现撤销或者恢复的功能里
 * 使得新的命令可以很容易的被加入到系统
 * 模拟教练发出攻击命令-防守命令-攻击命令-防守命令-防守命令-回放
 */
public class Client {
    public static void main(String [] args) {
        Athlete athlete = new Athlete();
        AttackCommand attackCommand = new AttackCommand();
        attackCommand.setAthlete(athlete);
        DefenseCommand defenseCommand = new DefenseCommand();
        defenseCommand.setAthlete(athlete);
        Coach coach = new Coach(attackCommand,defenseCommand);
        coach.attack();
        coach.defense();
        coach.attack();
        coach.defense();
        coach.defense();
        System.out.println("回放教练发出的指令");
        coach.rebroadcast();
    }
}