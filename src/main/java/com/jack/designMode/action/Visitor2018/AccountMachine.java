package com.jack.designMode.action.Visitor2018;

import java.util.List;

public class AccountMachine {
    private double amt;
    public void account(List list){
        Visitor visitor = new VisitorImpl();
        for (int i=0;i<list.size();i++) {
            amt += ((Goods)list.get(i)).accept(visitor);
        }
    }
    public double getAmt() {
        return amt;
    }
}