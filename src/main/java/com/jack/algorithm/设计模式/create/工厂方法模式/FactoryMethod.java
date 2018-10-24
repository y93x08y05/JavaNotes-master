package com.jack.algorithm.设计模式.create.工厂方法模式;

/**
 * 如果有新的产品加入，不会影响到原来的代码，后期维护容易
 * 增强系统可扩展性，只需要增加新的具体创建产品工厂类和具体产品类
 * 缺点是需要额外编写代码，增加了工作量
 */
public interface FactoryMethod {
    Animal createAnimal();
}