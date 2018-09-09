package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/14/2018 11:07 PM
 * LeetCode 58
 * 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，
 * 返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 一个单词是指由字母组成，但不包含任何空格的字符串。
 * 输入: "Hello World"
 * 输出: 5
 */
public class LastWordLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getLengthOfLastWord(s));
    }
    private static int getLengthOfLastWord(String s) {
        s=s.trim();
        if (s.length()==0)
            return 0;
        for (int i=s.length()-1;i>0;i--) {
            if (s.charAt(i)==' ')
                return s.substring(i+1,s.length()).length();
        }
        return s.length();
    }
}
