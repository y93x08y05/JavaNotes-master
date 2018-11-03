package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/21 22:22
 * LeetCode 30
 * 与所有单词相关联的字串
 * 给定一个字符串 s 和一些长度相同的单词 words。
 * 在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，
 * 但不需要考虑 words 中单词串联的顺序。
 * 例1:
 * 输入:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出: [0,9]
 * 解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 例2:
 * 输入:
 *   s = "wordgoodstudentgoodword",
 *   words = ["word","student"]
 * 输出: []
 */
public class FindSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        System.out.println(find(s, str));
    }
    private static List<Integer> find(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.equals("") ||words == null || words.length == 0)
            return list;
        Map<String,Integer> map = new HashMap<>();
        int len = words[0].length();
        int k = len;
        int count = words.length;
        for (String tmp : words) {
            if (!map.containsKey(tmp)) {
                map.put(tmp, 1);
            } else {
                map.put(tmp, map.get(tmp) + 1);
            }
        }
        String current;
        int start;
        for (int i = 0; i < k; i++) {
            Map<String, Integer> copy = new HashMap<>();
            start = i;
            for (int j = i; j + k <= s.length(); j = j + k) {
                current = s.substring(j, j + k);
                if (map.containsKey(current)) {
                    addRight(copy, current);
                    if (j + k - start > k * count) {
                        removeLeft(copy, s.substring(start, start + k));
                        start = start + k;
                    }
                    if (j + k - start == k * count && copy.equals(map))
                        list.add(start);
                } else {
                    copy.clear();
                    start = j + k;
                }
            }
        }
        return list;
    }
    private static void addRight(Map<String, Integer> copy, String current) {
        if (copy.containsKey(current))
            copy.put(current, copy.get(current) + 1);
        else
            copy.put(current, 1);
    }
    private static void removeLeft(Map<String, Integer> copy, String current) {
        int x = copy.get(current);
        if (x == 1)
            copy.remove(current);
        else
            copy.put(current, x - 1);
    }
}