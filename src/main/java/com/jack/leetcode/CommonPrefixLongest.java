package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 2:26 PM
 * LeetCode 14
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 例1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 例2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class CommonPrefixLongest {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(findLongestCommonPrefix(strings));
    }
    private static String findLongestCommonPrefix(String [] strings) {
        if (strings.length == 0)
            return "";
        String s = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(s) != 0)
                s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}
