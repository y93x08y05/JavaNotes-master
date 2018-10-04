package com.jack.algorithm.设计模式.action.Observer2018.example2;

public class ComputerClient implements StockObserver {

    @Override
    public void updateCount(String name) {
        System.out.println(name + "股票在电脑上的买卖数量更新了");
    }

    @Override
    public void updatePrice(String name) {
        System.out.println(name + "股票在电脑上的价格更新了");
    }
}