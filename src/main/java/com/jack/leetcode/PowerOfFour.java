package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 2:53 PM
 * LeetCode 342
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * 例1:
 * 输入: 16
 * 输出: true
 * 例2:
 * 输入: 5
 * 输出: false
 */
public class PowerOfFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPowerOfFour(n));
    }
    private static boolean isPowerOfFour(int num) {
        while (num > 1) {
            if (num % 4 == 0 && (num % 10 == 4 || num % 10 == 6))
                num /= 4;
            else
                return false;
        }
        if (num == 1)
            return true;
        return false;
    }
}
