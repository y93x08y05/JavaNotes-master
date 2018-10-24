package com.jack.algorithm.设计模式.action.策略模式;

public class InsuranceHeBei implements Insurance{
    @Override
    public void computerInsurance() {
        System.out.println("采用河北算法计算保险");
    }
}