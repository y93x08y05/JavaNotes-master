package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/21 21:42
 * LeetCode 91
 * 一条包含字母A-Z的消息通过以下方式进行了编码
 * 'A'--1
 * 'B'--2
 * 'Z'--26
 * 给定一个只包含数字的非空字符串，请计算解码方法总数
 * 例1：
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 例2：
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class NumDecoding {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(find(s));
    }
    private static int find(String s) {
        if (s.length()==0)
            return 0;
        int []dp=new int[s.length()];
        dp[0]=s.charAt(0)=='0'?0:1;
        if (s.length()==1)
            return dp[0];
        int k=s.charAt(0)>'0'&&s.charAt(1)>'0'?1:0;
        dp[1]=k+(s.charAt(0)=='1'||s.charAt(0)=='2'&&s.charAt(1)<='6'?1:0);
        for (int i=2;i<dp.length;i++) {
            if (s.charAt(i)!='0')
                dp[i]+=dp[i-1];
            if (s.charAt(i-1)=='1'||s.charAt(i-1)=='2'&&s.charAt(i)<='6') {
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()-1];
    }
}