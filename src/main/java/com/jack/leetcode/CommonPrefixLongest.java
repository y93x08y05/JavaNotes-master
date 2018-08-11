package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 2:26 PM
 * LeetCode 14
 * find if exists longest prefix of string from string array
 * if exists, then print prefix else print ""
 */
public class CommonPrefixLongest {
    public static void main(String[] args) {
        String [] strings = {"flower","flow","flight"};
        System.out.println(findLongestCommonPrefix(strings));
    }
    private static String findLongestCommonPrefix(String [] strs) {
        if (strs.length == 0)
            return "";
        String s = strs[0];
        for (int i=1;i<strs.length;i++) {
            while (strs[i].indexOf(s) != 0)
                s=s.substring(0,s.length()-1);
        }
        return s;
    }
}
