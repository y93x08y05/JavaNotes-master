package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/29 13:51
 * LeetCode 139
 * 单词拆分
 * 给定一个分空字符串s和一个包含非空单词列表的字典wordDict，
 * 判断s是否可以被空格拆分为一个或者多个在字典中出现的单词。
 * 拆分时可以重复使用字典中的单词，字典中没有重复的单词。
 * 例1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * "leetcode" 可以被拆分成 "leet code"。
 * 例2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * "applepenapple" 可以被拆分成 "apple pen apple"。
 * 例3：
 * 输入:
 * s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length; i++){
            list.add(str[i]);
        }
        System.out.println(find1(s, list));
        System.out.println(find2(s, list));
    }
    private static boolean find1(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String temp = s.substring(j, i);
                if (dp[j] && wordDict.contains(temp)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
    private static boolean find2(String s, List<String> wordDict) {
        if (wordDict.contains(s))
            return true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!queue.isEmpty()){
            int currentIndex = queue.poll();
            for (int i = currentIndex + 1; i <= s.length(); i++){
                if (visited.contains(i))
                    continue;
                if (wordDict.contains(s.substring(currentIndex, i))){
                    if (i == s.length())
                        return true;
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }
}