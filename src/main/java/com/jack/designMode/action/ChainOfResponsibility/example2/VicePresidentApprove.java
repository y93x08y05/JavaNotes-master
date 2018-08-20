package com.jack.designMode.action.ChainOfResponsibility.example2;

public class VicePresidentApprove extends Approve {
    @Override
    public void approve(BorrowBill borrowBill) {
        if (borrowBill.getAmt() >= 10000d &&
                borrowBill.getAmt() < 20000d) {
            System.out.println("财务副总审批了该借支单，借支单名称为：" +
                    borrowBill.getName() + ",该借支单金额为：" +
                    borrowBill.getAmt()
            );
        } else if (super.getSuccess() != null) {
            super.getSuccess().approve(borrowBill);
        }
    }
}