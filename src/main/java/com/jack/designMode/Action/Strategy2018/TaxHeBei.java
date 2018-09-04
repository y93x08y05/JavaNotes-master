package com.jack.designMode.action.Strategy2018;

public class TaxHeBei implements Tax{
    @Override
    public void computerTax() {
        System.out.println("采用河北算法计算所得税");
    }
}