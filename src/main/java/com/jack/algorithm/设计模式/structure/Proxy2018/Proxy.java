package com.jack.algorithm.设计模式.structure.Proxy2018;

/**
 * 代理模式就是给一个对象提供一个代理对象
 * 由代理对象控制对原对象的引用，使得代理类在客户端和原对象之间中介作用
 * 代理模式由抽象目标类，具体目标类和代理类组成。
 * 当系统需要对某个对象进行额外的控制时，使用代理模式。
 */
public class Proxy implements Subject{
    private RealSubject realSubject;
    @Override
    public void sampleOperation() {
        realSubject.sampleOperation();
    }
}