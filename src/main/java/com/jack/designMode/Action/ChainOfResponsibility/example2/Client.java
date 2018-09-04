package com.jack.designMode.action.ChainOfResponsibility.example2;

/**
 * 使用责任链模式可以降低类之间的耦合度
 * 使得处理类只需要保持一个指向其后继者的引用
 * 使得一个对象无需知道是其他哪一个对象处理其请求，对象仅需要知道
 * 该请求会被正确处理，接收者和发送者都没有对方的明确消息，
 * 处理方法增强了给对象指派职责的灵活性
 * 因为对象不知道是其他哪一个对象处理其请求，所有责任链模式不保证对象
 * 被接收，从而使得该请求可能一直到链接的末端都得不到处理。
 */
public class Client {
    public static void main(String [] args) {
        Approve departApprove = new DepartApprove();
        Approve financeApprove = new FinanceApprove();
        Approve vicePresidentApprove = new VicePresidentApprove();
        Approve managerApprove = new ManagerApprove();
        Approve chairmanApprove = new ChairmanApprove();
        departApprove.setSuccess(financeApprove);
        financeApprove.setSuccess(vicePresidentApprove);
        vicePresidentApprove.setSuccess(managerApprove);
        managerApprove.setSuccess(chairmanApprove);
        BorrowBill borrowBill = new BorrowBill();
        borrowBill.setName("出差借支单");
        borrowBill.setAmt(3000d);
        departApprove.approve(borrowBill);
        borrowBill.setName("出差借支单");
        borrowBill.setAmt(6000d);
        departApprove.approve(borrowBill);
        borrowBill.setName("采购办公用品借支单");
        borrowBill.setAmt(15000d);
        departApprove.approve(borrowBill);
        borrowBill.setName("采购原料借支单");
        borrowBill.setAmt(45000d);
        departApprove.approve(borrowBill);
        borrowBill.setName("采购原料借支单");
        borrowBill.setAmt(100000d);
        departApprove.approve(borrowBill);
    }
}