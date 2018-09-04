package com.jack.designMode.action.Strategy2018;

public class InsuranceHeBei implements Insurance{
    @Override
    public void computerInsurance() {
        System.out.println("采用河北算法计算保险");
    }
}