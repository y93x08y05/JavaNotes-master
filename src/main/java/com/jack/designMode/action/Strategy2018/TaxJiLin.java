package com.jack.designMode.action.Strategy2018;

public class TaxJiLin implements Tax{
    @Override
    public void computerTax() {
        System.out.println("采用吉林算法计算所得税");
    }
}