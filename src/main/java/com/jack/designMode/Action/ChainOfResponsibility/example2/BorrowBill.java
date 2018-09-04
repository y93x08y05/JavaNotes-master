package com.jack.designMode.action.ChainOfResponsibility.example2;

public class BorrowBill {
    private double amt = 0d;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
}