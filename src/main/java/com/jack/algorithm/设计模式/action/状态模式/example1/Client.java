package com.jack.algorithm.设计模式.action.状态模式.example1;

/**
 * 状态模式就是根据对象的状态不同，将有不同的行为
 * 状态模式主要有抽象状态类，具体状态类和上下文类组成
 * 状态模式使得代码中复杂的逻辑判断语句问题解决，
 * 而且具体状态角色将具体状态及其行为封装
 * 使用状态模式时，每个状态对应一个具体的状态类，
 * 使得结构分散，逻辑不清晰。
 */
public class Client {
    public static void main(String [] args){
        Document document = new Document();
        document.handle();
        document.handle();
        document.handle();
        document.handle();
        document.handle();
    }
}