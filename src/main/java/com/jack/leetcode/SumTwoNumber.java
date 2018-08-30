package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/28/2018 10:01 PM
 * LeetCode 371
 * find sum of two integer
 * 0+0=0
 * 1+0=1
 * 0+1=1
 * 1+1=1(with carry)
 * XOR不进位加法
 * 0^0=0
 * 1^1=0
 * 1^0=1
 * 0^1=1。
 */
public class SumTwoNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(findSum1(a, b));
        System.out.println(findSum2(a, b));
    }
    private static int findSum1(int a, int b) {
        if (b==0)
            return a;
        int sum=a^b;//不进位的加法
        int carry=(a&b)<<1;//由于是进位，所以将结果左移一位
        System.out.println("sum "+sum+" carry "+carry);
        return findSum1(sum,carry);
    }
    private static int findSum2(int a, int b) {
        while (b>0) {
            int carry=a&b;
            a=a^b;
            b=carry<<1;
        }
        return a;
    }
}
