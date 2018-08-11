package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 4:08 PM
 * LeetCode 28
 * find target first appear position from string
 * if exist output position else return -1
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
