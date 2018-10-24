package com.jack.algorithm.设计模式.action.策略模式;

public class Client {
    public static void main(String [] args){
        Strategy strategy = new Strategy();
        strategy.setSalary(new SalaryJiLin());
        strategy.setInsurance(new InsuranceJiLin());
        strategy.setTax(new TaxJiLin());
        strategy.computer();
    }
}