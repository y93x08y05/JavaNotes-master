package com.jack.algorithm.设计模式.action.观察者模式.example2;

public interface StockObserver {
    void updatePrice(String name);
    void updateCount(String name);
}