package com.jack.algorithm.设计模式.action.Observer2018.example2;

public interface StockObserver {
    void updatePrice(String name);
    void updateCount(String name);
}