package com.jack.algorithm.设计模式.action.Observer2018.example2;

import java.util.ArrayList;
import java.util.List;

public abstract class StockSubject {
    List list = new ArrayList();
    private String name ;

    public void changeCount(){
        notifyPrice();
    }

    public void changePrice(){
        notifyCount();

    }
    public void add(StockObserver stockObserver){
        list.add(stockObserver);
    }

    public void remove(StockObserver stockObserver){
        list.remove(stockObserver);
    }

    private void notifyCount() {
        for (int i=0;i<list.size();i++){
            StockObserver stockObserver = (StockObserver) list.get(i);
            stockObserver.updateCount(getName());
        }
    }

    public void notifyPrice(){
        for (int i=0;i<list.size();i++){
            StockObserver stockObserver = (StockObserver)list.get(i);
            stockObserver.updatePrice(getName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}