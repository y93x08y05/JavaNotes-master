package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 3:48 PM
 * LeetCode 633
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * 例1:
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 * 例2:
 * 输入: 3
 * 输出: False
 */
public class SquareSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(ifSquareSum(n));
    }
    private static boolean ifSquareSum(int n) {
        int half = n >> 1;
        int sb, b;
        for (int i = 0; i * i <= half; ++i) {
            sb = n - i * i;
            b = (int)Math.sqrt(sb);
            if (b * b == sb)
                return true;
        }
        return false;
    }
}
