package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/9/2018 3:00 PM
 * LeetCode 5
 * find longest palindrome subString from String
 * findLongestPalindrome1 using center search
 * findLongestPalindrome2 using dynamics programming
 */
public class LongestPalindromeSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(findLongestPalindrome1(s));
        System.out.println(findLongestPalindrome2(s));
    }
    private static String findLongestPalindrome1(String s) {
        if (s == null || s.length() <= 1)
            return s;
        int n = s.length();
        char [] chars = s.toCharArray();
        int max = 1;
        int maxIndex = 0;
        for (int i=0;i<n;i++) {
            int l = i;
            int r = i;
            while (r < n - 1 && chars[r] == chars[r+1])
                r++;
            while (l >= 0 && r <= n - 1 && chars[l] == chars[r]) {
                l--;
                r++;
            }
            l++;
            r--;
            if (r - l + 1 > max) {
                max = r - l + 1;
                maxIndex = l;
            }
        }
        return s.substring(maxIndex,maxIndex+max);
    }
    private static String findLongestPalindrome2(String s) {
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
