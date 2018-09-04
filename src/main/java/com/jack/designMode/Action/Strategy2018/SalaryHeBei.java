package com.jack.designMode.action.Strategy2018;

public class SalaryHeBei implements Salary{
    @Override
    public void computerSalary() {
        System.out.println("采用河北算法计算基本工资");
    }
}