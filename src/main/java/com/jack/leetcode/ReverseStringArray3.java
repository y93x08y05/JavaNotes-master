package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 4:42 PM
 * LeetCode 557
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，
 * 同时仍保留空格和单词的初始顺序。
 * 例：
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseStringArray3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseString(s));
    }
    private static String reverseString(String s) {
        if (s == null || s.length() == 0)
            return s;
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(new StringBuilder(str[i]).reverse());
            if (i != str.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
