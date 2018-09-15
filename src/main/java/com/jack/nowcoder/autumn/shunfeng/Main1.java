package com.jack.nowcoder.autumn.shunfeng;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/15 11:49
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(findLongestPalindrome1(sc.nextLine()));
    }
    private static String findLongestPalindrome1(String s) {
        if (s == null || s.length() <= 1)
            return s;
        int n = s.length();
        char [] chars = s.toCharArray();
        int max = 1;
        int maxIndex = 0;
        boolean dp[][] = new boolean[n][n];
        for (int i=0;i<n;i++) {
            dp[i][i] = true;
            maxIndex = i;
        }
        for (int i=0;i<n-1;i++) {
            if (chars[i] == chars[i+1]) {
                dp[i][i+1] = true;
                max = 2;
                maxIndex = i;
            }
        }
        for (int len=3;len<=n;len++) {
            for (int i=0;i<n-len+1;i++) {
                int j = i + len - 1;
                if (chars[i] == chars[j] && dp[i+1][j-1]) {
                    max = len;
                    maxIndex = i;
                    dp[i][j] = true;
                }
            }
        }
        return s.substring(maxIndex,maxIndex+max);
    }
}