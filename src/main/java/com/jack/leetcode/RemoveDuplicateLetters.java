package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 22:05
 * LeetCode 316
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，
 * 使得每个字母只出现一次。需保证返回结果的字典序最小
 * （要求不能打乱其他字符的相对位置）。
 * 例1:
 * 输入: "bcabc"
 * 输出: "abc"
 * 例2:
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 * 贪心算法
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(removeDuplicate(sc.next()));
    }
    private static String removeDuplicate(String s) {
        int []cnt=new int[26];
        int pos=0;
        for (int i=0;i<s.length();i++)
            cnt[s.charAt(i)-'a']++;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)<s.charAt(pos))
                pos=i;
            if (--cnt[s.charAt(i)-'a']==0)
                break;
        }
        return s.length()==0?"":s.charAt(pos)+removeDuplicate(s.substring(pos+1).replaceAll(""+s.charAt(pos),""));
    }
}