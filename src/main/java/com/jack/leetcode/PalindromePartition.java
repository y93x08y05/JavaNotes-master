package com.jack.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/7 15:13
 * LeetCode 131
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 例：
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartition {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(new PalindromePartition().find(s));
    }
    public List<List<String>> find(String s) {
        int [][]dp = new int[s.length()][s.length()];
        List<List<String>> result = new ArrayList<>();
        List<String> r = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int k = 0;
                for (; k < (j - i + 1) / 2; k++) {
                    if (s.charAt(i + k) != s.charAt(j - k))
                        break;
                }
                if (k == (j - i + 1) / 2)
                    dp[i][j] = 1;
            }
        }
        dfs(0,s,dp,r,result);
        return result;
    }
    public void dfs(int i, String s, int [][]dp, List<String> r, List<List<String>> result) {
        if (i == s.length()) {
            List<String> t = new ArrayList<>(r);
            Collections.reverse(t);
            result.add(t);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (dp[i][j] == 1) {
                r.add(0,s.substring(i,j+1));
                dfs(j+1,s,dp,r,result);
                r.remove(0);
            }
        }
    }
}