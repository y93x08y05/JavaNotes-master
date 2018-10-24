package com.jack.algorithm.设计模式.create.抽象工厂模式;

/**
 * 当一系列相关联产品设计到一个工厂类，则对其调用将会简单
 * 更换系列产品时，只需要增加另一个工厂类即可
 * 缺点需要修改抽象工厂类以及具体的工厂实现类，
 * 需要额外编写代码，增加工作量
 */
public interface AbstractFactory {
    Tiger createTiger();
    Dolphin createDolphin();
    Parrot createParrot();

}