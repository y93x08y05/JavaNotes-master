package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 4:26 PM
 * LeetCode 459
 * find repeated sub string from string and justify if could use
 * repeated sub string to compose string
 * if could return true else return false
 */
public class RepeatedSubString {
    public static void main(String[] args) {
        String s = "abcabcabc";
        System.out.println(findRepeatedSubString1(s));
        System.out.println(findRepeatedSubString2(s));
    }
    private static boolean findRepeatedSubString1(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                String temp = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < len / i; j++)
                    sb = sb.append(temp);
                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }
    private static boolean findRepeatedSubString2(String s) {
        int len = s.length();
        int i = 1;
        boolean flag = false;
        while (i<=len/2) {
            if (len % i == 0)
                flag = check(s,i);
            i++;
            if (flag)
                break;
        }
        return flag;
    }
    private static boolean check(String s,int distance) {
        int len = s.length();
        for (int i=0;i<distance;i++) {
            for (int j=i+distance;j<len;j+=distance) {
                if (s.charAt(i)!=s.charAt(j))
                    return false;
            }
        }
        return true;
    }
}
