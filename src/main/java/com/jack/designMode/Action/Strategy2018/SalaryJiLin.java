package com.jack.designMode.action.Strategy2018;

public class SalaryJiLin implements Salary{
    @Override
    public void computerSalary() {
        System.out.println("采用吉林算法计算基本工资");
    }
}