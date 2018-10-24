package com.jack.algorithm.设计模式.action.策略模式;

public class TaxHeBei implements Tax{
    @Override
    public void computerTax() {
        System.out.println("采用河北算法计算所得税");
    }
}