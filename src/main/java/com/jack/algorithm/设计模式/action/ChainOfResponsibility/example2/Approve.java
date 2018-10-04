package com.jack.algorithm.设计模式.action.ChainOfResponsibility.example2;

public abstract class Approve {
    private Approve success;
    public abstract void approve(BorrowBill borrowBill);

    public Approve getSuccess() {
        return success;
    }

    public void setSuccess(Approve success) {
        this.success = success;
    }
}