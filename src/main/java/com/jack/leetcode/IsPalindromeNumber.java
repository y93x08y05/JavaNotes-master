package com.jack.leetcode;

/**
 * Created by Jack on 8/2/2018 2:57 PM
 * LeetCode 9
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例1:
 * 输入: 121
 * 输出: true
 * 例2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 例3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class IsPalindromeNumber {
    public static void main(String[] args) {
        int m = 121;
        System.out.println(getValue(m));
    }
    public static boolean getValue(int x) {
        if (new StringBuilder(String.valueOf(x)).reverse().toString().equals(String.valueOf(x))) {
            return true;
        } else {
            return false;
        }
    }
}
