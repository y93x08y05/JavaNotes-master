package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/19/2018 9:06 PM
 * LeetCode 29
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 例1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 例2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，
 * 如果除法结果溢出，则返回 231 − 1。
 */
public class TwoNumberDivide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(findDivide(m, n));
    }
    private static int findDivide(int m,int n) {
        int flag=1;
        if ((m<0&&n>0)||(m>0&&n<0))
            flag=-1;
        long a = Math.abs((long)m);
        long b = Math.abs((long)n);
        if (a==0||a<b)
            return 0;
        if (b==0)
            return Integer.MAX_VALUE;
        long res = findDivide(a,b);
        int ans;
        if (res>Integer.MAX_VALUE)
            ans=flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        else
            ans=(int)(flag*res);
        return ans;
    }
    private static long findDivide(long a,long b) {
        if (a<b)
            return 0;
        long res=1;
        long sum=b;
        while (sum+sum<=a) {
            sum+=sum;
            res+=res;
        }
        return res+findDivide(a-sum,b);
    }
}
