package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/14 23:23
 * LeetCode 389
 * 找不同
 * 给定两个字符串s和t，它们只包含小写字母。
 * 字符串t由字符串s随机重排，然后在随机位置添加一个字母。
 * 请找出在t中被添加的字母。
 * 例：
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * 输出：
 * e
 * 解释：
 * 'e' 是那个被添加的字母。
 */
public class FindDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(new FindDifference().find0(s, t));
        System.out.println(new FindDifference().find1(s, t));
    }
    public char find0(String s, String t) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int i;
        for (i = 0; i < s.length(); i++)
            count1[s.charAt(i) - 'a']++;
        for (i = 0; i < t.length(); i++)
            count2[t.charAt(i) - 'a']++;
        for (i = 0; i < 26; i++)
            if (count1[i] != count2[i])
                return (char) ('a' + i);
        return 0;
    }
    public char find1(String s, String t) {
        char temp = 0x00;
        int i;
        for (i = 0; i < s.length(); i++)
            temp = (char) (temp ^ s.charAt(i));
        for (i = 0; i < t.length(); i++)
            temp = (char) (temp ^ t.charAt(i));
        return temp;
    }
}