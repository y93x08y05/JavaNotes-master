package com.jack.剑指Offer;

/**
 * @Author: Jack
 * @Date: 2018/9/14 22:35
 * 给定一个double类型的浮点数base和int类型的整数
 * exponent。求base的exponent次方。
 */
public class Main29 {
    public static void main(String[] args) {
        System.out.println(new Main29().Power(2.0, 3));
    }
    public double Power(double base, int exponent) {
        double result=1.0;
        if(exponent==0)
            return 1;
        else if(exponent>0) {
            for(int i=1;i<=exponent;i++) {
                result*=base;
            }
        } else if(base==0)
            throw new RuntimeException("");
        for(int i=1;i<=-exponent;i++) {
            result*=base;
        }
        return exponent>0?result:(1/result);
    }
}