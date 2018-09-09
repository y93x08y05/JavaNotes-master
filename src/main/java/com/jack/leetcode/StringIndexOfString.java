package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 4:08 PM
 * LeetCode 28
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * 例1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 例2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class StringIndexOfString {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        System.out.println(findStringIndexOfString(s1, s2));
    }
    private static int findStringIndexOfString(String haystack,String needle) {
        if (needle.equals(""))
            return 0;
        if (haystack.length()<needle.length())
            return -1;
        int index = haystack.indexOf(needle);
        return index;
    }
}
