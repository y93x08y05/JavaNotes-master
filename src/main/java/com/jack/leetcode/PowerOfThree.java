package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 2:35 PM
 * LeetCode 326
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 例1:
 * 输入: 27
 * 输出: true
 * 例2:
 * 输入: 0
 * 输出: false
 * 例3:
 * 输入: 9
 * 输出: true
 * 例4:
 * 输入: 45
 * 输出: false
 */
public class PowerOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPowerOfThree(n));
    }
    private static boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 == 0 && (n % 10 == 1 || n % 10 == 3 || n % 10 == 7 || n % 10 == 9))
                n/=3;
            else
                return false;
        }
        if (n == 1)
            return true;
        return false;
    }
}
