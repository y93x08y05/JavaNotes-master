package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 16:25
 * LeetCode 343
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积。
 * 例1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 例2：
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 能够拆分出足够多的3就能够使得乘积最大
 */
public class IntegerBreak {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(findMaxMultiply0(n));
        System.out.println(findMaxMultiply1(n));
    }
    private static int findMaxMultiply0(int n) {
        if (n==2)
            return 1;
        if (n==3)
            return 2;
        int res=1;
        while (n>4) {
            res*=3;
            n-=3;
        }
        return res*n;
    }
    private static int findMaxMultiply1(int n) {
        if (n==2)
            return 1;
        if (n==3)
            return 2;
        double result;
        int n3=n/3;
        int shift=n%3;
        result=Math.pow(3,n3);
        if (shift==1)
            result=result/3*4;
        else if (shift==2)
            result*=2;
        return (int) result;
    }
}