package com.jack.designMode.action.Observer2018.example2;

public class PhoneClient implements StockObserver {
    @Override
    public void updateCount(String name) {
        System.out.println(name + "股票在手机上的买卖数量更新了");
    }

    @Override
    public void updatePrice(String name) {
        System.out.println(name + "股票在手机上的价格更新了");
    }
}