package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/19/2018 10:20 PM
 * LeetCode 415
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库，
 * 也不能直接将输入的字符串转换为整数形式。
 */
public class StringAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(computeStringAdd(s1, s2));
    }
    private static String computeStringAdd(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i >= 0)
                carry += s1.charAt(i--) - '0';
            if (j >= 0)
                carry += s2.charAt(j--) - '0';
            sb.append(Integer.toString(carry % 10));
            carry /= 10;
        }
        return carry != 0 ? "1" + sb.toString() : sb.toString();
    }
}
