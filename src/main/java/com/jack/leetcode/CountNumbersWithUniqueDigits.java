package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 15:33
 * LeetCode 357
 * 给定一个非负整数n，计算各位数字都不同的数字x的个数，其中0≤x<10^n。
 * 例1：
 * 输入:2
 * 输出:91
 * 解释:除去11,22,33,44,55,66,77,88,99外，在[0,100)区间内的所有数字。
 */
public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findCount(n));
    }
    private static int findCount(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        int digits = 9;
        int val = 10;
        for (int i = 2; i <= n; i++) {
            digits *= (9 - i + 2);
            val = val + digits;
        }
        return val;
    }
}