package com.jack.algorithm.设计模式.action.Visitor2018;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List list = new ArrayList<>();
    public void add(Object object) {
        list.add(object);
    }
    public void remove(Object object) {
        list.remove(object);
    }
    public List getList() {
        return list;
    }
}