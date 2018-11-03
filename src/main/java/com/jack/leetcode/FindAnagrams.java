package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/5 9:22
 * LeetCode 438
 * 给定一个字符串s和一个非空字符串p，
 * 找到s中所有是p的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串s和p的长度都不超过 20100。
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 例1
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * use sliding window to solve subSequence problem
 */
public class FindAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        List<Integer> list1 = findAnagrams0(s, p);
        for (Integer i : list1)
            System.out.println(i);
        List<Integer> list2 = findAnagrams1(s, p);
        for (Integer i : list2)
            System.out.println(i);
        List<Integer> list3 = findAnagrams2(s, p);
        for (Integer i : list3)
            System.out.println(i);
    }
    private static List<Integer> findAnagrams0(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return list;
        }
        int[] hash = new int[256];//ASCII码长度为256
        char[] chars = p.toCharArray();
        for (char c : chars) {
            hash[c]++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- > 0)
                count--;
            if (count == 0)
                list.add(left);
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
                count++;
        }
        return list;
    }
    private static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length())
            return list;
        int len = p.length();
        int i = 0;
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        while (i + len <= s.length()) {
            char[] temp = s.substring(i, i + len).toCharArray();
            Arrays.sort(temp);
            if (new String(chars).equals(new String(temp))) {
                list.add(i);
            }
            i++;
        }
        return list;
    }
    private static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] chars = new int[26];
        if (s == null || p == null || s.length() < p.length())
            return list;
        for (char c : p.toCharArray()) {
            chars[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        while (right < s.length()) {
            if (--chars[s.charAt(right++)] >= 0)
                count--;
            if (count == 0)
                list.add(left);
            if (right - left == p.length() && chars[s.charAt(left++) - 'a']++ >= 0)
                count++;
        }
        return list;
    }
}