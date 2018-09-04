package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/4 23:48
 * LeetCode 680
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 例1:
 * 输入: "aba"
 * 输出: True
 * 例2:
 * 输入: "abca"
 * 输出: True
 * 解释: 可以删除c字符。
 */
public class IsPalindrome2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(isPalindrome2(s));
    }
    private static boolean isPalindrome2(String s) {
        if (s.length()<=2)
            return true;
        return checkResult(s,0,s.length()-1,1);
    }
    private static boolean checkResult(String s,int l,int r,int count) {
        char []chars=s.toCharArray();
        while (l<=r-1) {
            if (chars[l]!=chars[r]) {
                if (count<=0)
                    return false;
                return checkResult(s,l+1,r,count-1)||checkResult(s,l,r-1,count-1);
            }
            l++;
            r--;
        }
        return true;
    }
}