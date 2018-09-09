package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 22:06
 * LeetCode 387
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 */
public class FirstUniqueChar {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(findFirstUniqueChar(s));
    }
    private static int findFirstUniqueChar(String s) {
        int []a=new int[26];
        for (int i=0;i<s.length();i++) {
            a[s.charAt(i)-'a']++;
        }
        for (int i=0;i<s.length();i++) {
            if (a[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}