package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 9:59
 * LeetCode 434
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 输入: "Hello, my name is John"
 * 输出: 5
 */
public class CountSegments {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(findWordCount(s));
    }
    private static int findWordCount(String s) {
        String s1=s.trim();
        if (s1.length()==0)
            return 0;
        else
            return s1.split("\\s+").length;
    }
}