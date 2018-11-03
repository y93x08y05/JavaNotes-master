package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/9/2018 3:40 PM
 * LeetCode 516
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * 例1:
 * 输入:
 * "bbbab"
 * 输出:
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * 例2:
 * 输入:
 * "cbbd"
 * 输出:
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 */
public class LongestPalindromeSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(findLongestPalindrome1(s));
        System.out.println(findLongestPalindrome2(s));
    }
    private static int findLongestPalindrome1(String s) {
        int len = s.length();
        if(len == 0)
            return 0;
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++)
            dp[i][i] = 1;
        for(int i = 1; i < len; i++)
            for(int j = 0; i + j < len; j++) {
                if(j == i + j - 1)
                    dp[j][i + j] = s.charAt(j) == s.charAt(i + j) ? 2 : 1;
                else
                    dp[j][i + j] = Math.max(Math.max(dp[j + 1][i + j], dp[j][i + j - 1]), dp[j + 1][i + j - 1] + (s.charAt(j) == s.charAt(i + j) ? 2 : 0));
            }
        return dp[0][len - 1];
    }
    private static String findLongestPalindrome2(String s) {
        if (s == null || s.length() <= 1)
            return s;
        System.out.println(Arrays.toString(s.toCharArray()));
        int len = s.length();
        String[] result = new String[len];
        result[0] = "" + s.charAt(0);
        int[][] matrix = new int[len][len];
        for (int j = 0; j < len; j++) {
            matrix[j][j] = 1;
        }
        int startIndex = 0;
        int endIndex = 0;
        int maxLen = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    int preLen = matrix[i + 1][j - 1];
                    matrix[i][j] = 2 + preLen;
                    if (maxLen <= matrix[i][j]) {
                        maxLen = matrix[i][j];
                        StringBuilder sb = new StringBuilder();
                        if (preLen == 1) {
                            sb.append(s.charAt(i));
                            sb.append(s.charAt(i + 1));
                            sb.append(s.charAt(j));
                        } else if (preLen == 0) {
                            sb.append(s.charAt(i));
                            sb.append(s.charAt(j));
                        } else {
                            sb.append(s.charAt(i));
                            sb.append(result[preLen - 1]);
                            sb.append(s.charAt(j));
                        }
                        result[maxLen - 1] = sb.toString();
                        startIndex = i;
                        endIndex = j;
                    }
                } else {
                    matrix[i][j] = Math.max(matrix[i + 1][j], matrix[i][j - 1]);
                }
            }
        }
        System.out.println("startIndex:" + startIndex + " endIndex" + endIndex);
        System.out.println("maxLen:" + maxLen);
        System.out.println("subString:" + s.substring(startIndex, endIndex + 1));
        String longestSubSequence = null;
        for (int i = 0; i < len; i++) {
            if (result[i] != null && result[i].length() == maxLen) {
                longestSubSequence = result[i];
                break;
            }
        }
        return longestSubSequence;
    }
}
