package com.jack.leetcode;

/**
 * Created by Jack on 8/24/2018 8:43 PM
 * LeetCode 50
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 例1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 例2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 例3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Pow1 {
    public static void main(String[] args) {
        double x=2.0000;
        int n=-2147483648;
        Pow1 pow=new Pow1();
        System.out.println(pow.computeValue0(x, n));
        System.out.println(pow.computeValue1(x, n));
        System.out.println(pow.computeValue2(x, n));
        System.out.println(pow.computeValue3(x, n));
        System.out.println(pow.computeValue4(x, n));
        System.out.println(pow.computeValue5(x, n));
    }
    //n = 13，13在二进制中表示为：00001101，那么13 = 2^3 + 2^2 + 2^0
    //m的二进制为1的位将结果乘入p中，m=13，共将p的结果乘入3次
    private double computeValue0(double x,int n) {
        int m=n<0?-n-1:n;
        double p=1;
        for (double q=x;m>0;m/=2) {
            if ((m&1)!=0)
                p*=q;
            q*=q;
        }
        return n<0?1/p/x:p;
    }
    //right method to keep time complexity and value out of Integer
    private double computeValue1(double x,int n) {
        if (n==0)
            return 1;
        if (n==1)
            return x;
        int t=n/2;
        if (n<0) {
            t=-t;
            x=1/x;
        }
        double result=computeValue1(x,t);
        if (n%2==0)
            return result*result;
        return result*result*x;
    }
    private double computeValue2(double x,int n) {
        if (n==0)
            return 1.0;
        else if (n>0) {
            double half= computeValue2(x,n/2);
            if (n%2==0)
                return half*half;
            else
                return half*half*x;
        } else {
            if (n==Integer.MIN_VALUE) {
                double half= computeValue2(x,n/2);
                return 1.0/(half*half);
            }
            n=-n;
            double half= computeValue3(x,n/2);
            if (n%2==0)
                return 1.0/(half*half);
            else
                return 1.0/(half*half*x);
        }
    }
    //border condition if n=-2147483648 and then n=-n will out of Integer
    private double computeValue3(double x,int n) {
        if (n==0)
            return 1.0;
        else if (n>0) {
            double half= computeValue3(x,n/2);
            if (n%2==0)
                return half*half;
            else
                return half*half*x;
        } else {
            n=-n;
            double half= computeValue3(x,n/2);
            if (n%2==0)
                return 1.0/(half*half);
            else
                return 1.0/(half*half*x);
        }
    }
    //StackOverflowError
    private double computeValue4(double x,int n) {
        if (n==0)
            return 1.0;
        if (n<0)
            return 1.0/ computeValue4(x,-n);
        return x* computeValue4(x,n-1);
    }
    //time out
    private double computeValue5(double x,int n) {
        if (n==0)
            return 1.0;
        double sum=x;
        int m=Math.abs(n);
        for (int i=0;i<m-1;i++) {
            sum*=x;
        }
        if (n<0)
            return 1/sum;
        else
            return sum;
    }
}
