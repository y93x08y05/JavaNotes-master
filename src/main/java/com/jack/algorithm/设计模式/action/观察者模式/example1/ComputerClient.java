package com.jack.algorithm.设计模式.action.观察者模式.example1;

import java.util.Observable;
import java.util.Observer;

public class ComputerClient implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String name = (String)arg;
        System.out.println(name + "股票在电脑上的价格更新了");
        System.out.println(name + "股票在电脑上的买卖数量更新了");
    }
}