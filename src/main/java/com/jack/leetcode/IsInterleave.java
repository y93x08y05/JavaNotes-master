package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/29 15:42
 * LeetCode 97
 * 给定三个字符串s1,s2,s3
 * 验证s3是否是s1和s2的交错字符串
 * 例1:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 例2:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 */
public class IsInterleave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        System.out.println(new IsInterleave().find(s1, s2, s3));
    }
    private boolean find(String s1, String s2, String s3){
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3)
            return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++){
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for (int j = 0; j <= len2; j++){
            dp[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
        }
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[len1][len2];
    }
}