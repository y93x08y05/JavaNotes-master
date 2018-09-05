package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 23:49
 * LeetCode 504
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * 例1:
 * 输入: 100
 * 输出: "202"
 * 例2:
 * 输入: -7
 * 输出: "-10"
 */
public class ConvertBase7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(convertBase7_0(n));
        System.out.println(convertBase7_1(n));
    }
    private static String convertBase7_0(int n) {
        return Integer.toString(n,7);
    }
    private static String convertBase7_1(int n) {
        StringBuilder sb=new StringBuilder();
        if (n==0)
            return 0+"";
        int num=Math.abs(n);
        while (num!=0) {
            int res=num%7;
            num=num/7;
            sb.insert(0,res+"");
        }
        if (n<0)
            sb.insert(0,"-");
        return sb.toString();
    }
}