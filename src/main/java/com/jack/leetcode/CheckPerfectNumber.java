package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 23:41
 * LeetCode 507
 * 完美数
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * 给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False
 * 例：
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 */
public class CheckPerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(ifPerfectNumber(n));
    }
    private static boolean ifPerfectNumber(int n) {
        if (n == 1)
            return false;
        int sum = 1;
        int up = (int) Math.sqrt(n);
        for (int i = 2; i <= up; i++) {
            if (n % i == 0) {
                sum += i;
                sum += n / i;
            }
        }
        return sum == n;
    }
}