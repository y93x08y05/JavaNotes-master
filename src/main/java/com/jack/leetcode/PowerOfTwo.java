package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 2:13 PM
 * LeetCode 231
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 例1:
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 例2:
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 例3:
 * 输入: 218
 * 输出: false
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPowerOfTwo(n));
    }
    private static boolean isPowerOfTwo(int n) {
        while (n > 1) {
            if (n % 2 == 1)
                return false;
            n = n / 2;
        }
        if ( n == 1)
            return true;
        return false;
    }
}
