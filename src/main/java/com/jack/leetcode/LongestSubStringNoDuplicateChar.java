package com.jack.leetcode;

import java.util.*;

/**
 * Created by Jack on 8/16/2018 11:37 PM
 * LeetCode 3
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 例1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 例2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * 例3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 * 请注意，答案必须是一个子串，"pwke" 是一个子序列而不是子串。
 */
public class LongestSubStringNoDuplicateChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(findLongestSubString1(s));
        System.out.println(findLongestSubString2(s));
        System.out.println(findLongestSubString3(s));
    }
    private static int findLongestSubString1(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1;j <= s.length(); j++) {
                if (isTrue(s,i,j))
                    res = Math.max(res,j-i);
            }
        }
        return res;
    }
    private static int findLongestSubString2(String s) {
        int n = s.length();
        int res = 0;
        int end = 0;
        int start = 0;
        Set<Character> set = new HashSet<>();
        while (start < n && end < n) {
            if (set.contains(s.charAt(end)))
                set.remove(s.charAt(start++));
            else {
                set.add(s.charAt(end++));
                res = Math.max(res,end - start);
            }
        }
        return res;
    }
    private static int findLongestSubString3(String s) {
        int n = s.length();
        int res = 0;
        int end = 0;
        int start = 0;
        Map<Character,Character> map = new HashMap<>();
        for (;start < n && end < n; end++) {
            if (map.containsKey(s.charAt(end)))
                start = Math.max(map.get(s.charAt(end)),start);
            map.put(s.charAt(end), (char) (end+1));
            res = Math.max(res,end-start+1);
        }
        return res;
    }
    private static boolean isTrue(String s,int start,int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i)))
                return false;
            set.add(s.charAt(i));
        }
        return true;
    }
}
