package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 3:28 PM
 * LeetCode 367
 * 给定一个正整数 num，编写一个函数，
 * 如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 不要使用任何内置的库函数，如  sqrt。
 * 例1：
 * 输入：16
 * 输出：True
 * 例2：
 * 输入：14
 * 输出：False
 */
public class PerfectSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPerfectSquare(n));
    }
    private static boolean isPerfectSquare(int n) {
        for (int i=1;n>0;i+=2) {
            n-=i;
        }
        return 0==n;
    }
}
