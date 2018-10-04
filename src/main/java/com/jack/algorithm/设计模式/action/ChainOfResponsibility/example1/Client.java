package com.jack.algorithm.设计模式.action.ChainOfResponsibility.example1;

/**
 * 责任链模式就是使多个对象都有机会处理请求，
 * 从而避免请求的发送者和接收者之间的耦合关系，
 * 将对象连成一条链并且沿着链传递请求，直到有一个对象处理为止。
 * 将病人的请求封装在由不同医生组成的链上，直到有一个医生处理为止，
 * 消除了判断语句使用，并划分了类的职责
 */

public class Client {
    public static void main(String [] args){
        Jack jack = new Jack();
        Doctor nerveDoctor = new NerveDoctor();
        Doctor sleepDoctor = new SleepDoctor();
        Doctor assimilationDoctor = new AssimilationDoctor();
        nerveDoctor.setDoctor(sleepDoctor);
        sleepDoctor.setDoctor(assimilationDoctor);
        jack.setHead(new Boolean(true));
        nerveDoctor.seeDoctor(jack);
    }
}