package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 2:09 PM
 * LeetCode 541
 * 反转字符串
 * 给定一个字符串和一个整数k，你需要对从字符串开头算起的每个2k个字符的前k个字符
 * 进行反转。如果剩余小于k个字符，则将剩余的所有全部反转，如果有小于2k但大于或者
 * 等于k个字符，则反转前k个字符，并将剩余的字符保持原样。
 * 例1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class ReverseStringArray2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(reverseString(s, k));
        String s1 = "abcd";
        System.out.println(reverseString(s1));
    }
    private static String reverseString(String s, int k) {
        int len = s.length();
        String result = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i += 2 * k) {
            if (len - i < k) {
                String temp = new StringBuilder(s.substring(i, len)).reverse().toString();
                sb.append(temp);
            } else if (len - i < 2 * k && len - i >= k) {
                String temp = new StringBuilder(s.substring(i, i + k)).reverse().toString();
                sb.append(temp);
                sb.append(s, i + k, len);
            } else {
                String temp = new StringBuilder(s.substring(i, i + k)).reverse().toString();
                sb.append(temp);
                sb.append(s, i + k, i + 2 * k);
            }
        }
        return result;
    }
    private static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++)
            sb.append(s.charAt(i));
        return sb.toString();
    }
}
