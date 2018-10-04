package com.jack.algorithm.设计模式.action.Observer2018.example2;

public class Stock extends StockSubject{
    @Override
    public void changeCount() {
        setName("中信证券");
        super.changeCount();
    }

    @Override
    public void changePrice() {
        setName("中信证券");
        super.changePrice();
    }
}