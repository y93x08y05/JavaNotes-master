package com.jack.algorithm.设计模式.action.策略模式;

public class TaxJiLin implements Tax{
    @Override
    public void computerTax() {
        System.out.println("采用吉林算法计算所得税");
    }
}