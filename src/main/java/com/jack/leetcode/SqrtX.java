package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 3:18 PM
 * LeetCode 69
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 例1:
 * 输入: 4
 * 输出: 2
 * 例2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class SqrtX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(findSqrt(x));
    }
    private static int findSqrt(int x) {
        return Integer.valueOf(String.valueOf(Math.sqrt(x)).substring(0,String.valueOf(Math.sqrt(x)).indexOf(".")));
    }
}
