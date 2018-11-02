package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/6 18:11
 * LeetCode 792
 * 给定字符串S和单词字典 words, 求words[i]中是S的子序列的单词个数。
 * 示例:
 * 输入:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * 输出: 3
 * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 */
public class MatchingSubSequenceNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        System.out.println(matchingSubSequence(s, words));
    }
    private static int matchingSubSequence(String s, String[] words) {
        int n = s.length();
        int[][] next = new int[n + 1][26];
        char[] sc = s.toCharArray();
        Arrays.fill(next[n], -1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                next[i][j] = next[i + 1][j];
            }
            next[i][sc[i] - 'a'] = i + 1;
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (isSubSequence(next, words[i]))
                res++;
        }
        return res;
    }
    private static boolean isSubSequence(int[][] next, String s) {
        char[] sc = s.toCharArray();
        int j = 0;
        for (int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if (next[j][c - 'a'] > -1)
                j = next[j][c - 'a'];
            else
                return false;
        }
        return true;
    }
}