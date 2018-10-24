package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/4 22:54
 * LeetCode 125
 * 给定一个字符串，验证它是否是回文串，
 * 只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 例1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 例2:
 * 输入: "race a car"
 * 输出: false
 * A man, a plan, a canal: Panama
 */
public class IsPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(new IsPalindrome().isPalindrome(s));
    }
    private boolean isPalindrome(String s) {
        if (s == null || s.length() < 2)
            return true;
        int len = s.length() - 1;
        char c1,c2;
        for (int i = 0; i < s.length() - 1; i++) {
            if (!isValid(s.charAt(i)))
                continue;
            c1 = s.charAt(i);
            while (len >= 0 && !isValid(s.charAt(len)))
                len--;
            c2 = s.charAt(len);
            if (!isSame(c1,c2))
                return false;
            else
                len--;
        }
        return true;
    }
    private boolean isValid(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
    private boolean isSame(char a,char b) {
        if (a < 65 || b < 65) {
            if (a == b) {
                return true;
            } else {
                return false;
            }
        } else {
            if (a == b || Math.abs(a - b) == 32)
                return true;
            else
                return false;
        }
    }
}