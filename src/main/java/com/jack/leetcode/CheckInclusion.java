package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 10:26
 * LeetCode 567
 * 给定两个字符串s1和s2，写一个函数来判断s2是否包含s1的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class CheckInclusion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(findIfInclusion1(s1, s2));
        System.out.println(findIfInclusion2(s1, s2));
    }
    private static boolean findIfInclusion1(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String target = s2.substring(i, i + s1.length());
            if (helper3(chars, target))
                return true;
        }
        return false;
    }
    private static boolean findIfInclusion2(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']++;
        }
        if (helper4(count))
            return true;
        for (int i = s1.length(); i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - s1.length()) - 'a']++;
            if (helper4(count))
                return true;
        }
        return false;
    }
    private static boolean helper3(int[] chars, String target) {
        int[] temp = new int[26];
        for (int i = 0; i < chars.length; i++) {
            temp[i] = chars[i];
        }
        for (int i = 0; i < target.length(); i++) {
            if (temp[target.charAt(i) - 'a'] > 0)
                temp[target.charAt(i) - 'a']--;
            else
                return false;
        }
        return true;
    }
    private static boolean helper4(int[] count) {
        for (int i : count) {
            if (i != 0)
                return false;
        }
        return true;
    }
}