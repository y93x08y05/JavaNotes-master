package com.jack.algorithm.设计模式.action.策略模式;

public class SalaryHeBei implements Salary{
    @Override
    public void computerSalary() {
        System.out.println("采用河北算法计算基本工资");
    }
}