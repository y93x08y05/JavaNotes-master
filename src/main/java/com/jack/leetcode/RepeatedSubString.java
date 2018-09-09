package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 4:26 PM
 * LeetCode 459
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 例1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 例2:
 * 输入: "aba"
 * 输出: False
 * 例3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class RepeatedSubString {
    public static void main(String[] args) {
        String s = "abcabcabc";
        System.out.println(findRepeatedSubString1(s));
        System.out.println(findRepeatedSubString2(s));
    }
    private static boolean findRepeatedSubString1(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                String temp = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < len / i; j++)
                    sb = sb.append(temp);
                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }
    private static boolean findRepeatedSubString2(String s) {
        int len = s.length();
        int i = 1;
        boolean flag = false;
        while (i<=len/2) {
            if (len % i == 0)
                flag = check(s,i);
            i++;
            if (flag)
                break;
        }
        return flag;
    }
    private static boolean check(String s,int distance) {
        int len = s.length();
        for (int i=0;i<distance;i++) {
            for (int j=i+distance;j<len;j+=distance) {
                if (s.charAt(i)!=s.charAt(j))
                    return false;
            }
        }
        return true;
    }
}
