package com.jack.nowcoder.autumn.disifanshi;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 15:30
 * 给定一个字符串，数字或大小写字母，找出最长的对称的子串
 * 如果存在多个，则输出任意一个。
 * 输入描述：
 * 字符串
 * 输出描述：
 * 字符串
 * 例：
 * 输入：a1223a
 * 输出：22
 * 输入：abbbaad
 * 输出：abba
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(findMaxLengthSubString(s));
        System.out.println(findMaxLengthSubString(s));
    }
    private static String findMaxLengthSubString(String s) {
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
    private static String findMaxLengthSubString1(String s) {
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
}