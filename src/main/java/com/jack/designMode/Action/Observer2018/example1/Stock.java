package com.jack.designMode.action.Observer2018.example1;

import java.util.Observable;

public class Stock extends Observable{
    public void changeCountAndPrice(){
        setChanged();//做标记这个被观察者已经被改变，设置为true
        notifyObservers("中信证券");
    }
}