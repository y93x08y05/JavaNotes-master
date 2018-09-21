package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/21 10:56
 * LeetCode 647
 * 回文字串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成
 * 也认为是不同的子串。
 * 例1：
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 例2：
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 */
public class CountSubString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(findCount(sc.nextLine()));
    }
    private static int findCount(String s) {
        int len=s.length();
        int []dp=new int[len];
        for (int i=1;i<len;i++) {
            int tmpNum=0;
            for (int j=0;j<i;j++) {
                if (s.charAt(i)==s.charAt(j)) {
                    String subStr=s.substring(j,i+1);
                    if (isPalindromic(subStr))
                        tmpNum++;
                }
            }
            dp[i]=dp[i-1]+tmpNum;
        }
        return dp[len-1]+len;
    }
    private static boolean isPalindromic(String s) {
        for (int i=0;i<(s.length()/2);i++) {
            if (s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

}