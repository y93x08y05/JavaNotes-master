package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 9/2/2018 6:32 PM
 * LeetCode 258
 * 给定一个非负整数num，反复将各个位上的数字相加，直到结果为一位数。
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。
 * 由于 2 是一位数，所以返回 2。
 */
public class AddDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(addDigits(sc.nextInt()));
    }
    private static int addDigits(int n) {
        if (String.valueOf(n).length() == 1)
            return n;
        String s = String.valueOf(n);
        int m = 0;
        for (int i = 0; i < s.length(); i++) {
            m += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return addDigits(m);
    }
}
