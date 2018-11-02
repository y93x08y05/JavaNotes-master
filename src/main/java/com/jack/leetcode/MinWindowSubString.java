package com.jack.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 11:04
 * LeetCode 76
 * 给定一个字符串S和一个字符串T，请在S中找出包含T所有字母的最小子串。
 * 例1：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，保证它是唯一的答案。
 */
public class MinWindowSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(findMinWindow(s, t));
    }
    private static String findMinWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        int count = t.length();
        for (char c : t.toCharArray())
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char val = s.charAt(right);
            if (map.containsKey(val)) {
                map.put(val, map.get(val) - 1);
                if (map.get(val) >= 0)
                    count--;
            }
            while (count == 0) {
                if (right - left < min) {
                    min = right - left;
                    minStart = left;
                    minEnd = right;
                }
                char temp = s.charAt(left);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0)
                        count++;
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd + 1);
    }
}