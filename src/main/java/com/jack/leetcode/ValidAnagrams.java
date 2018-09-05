package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 0:27
 * LeetCode 242
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * 例1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 例2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class ValidAnagrams {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(isValidAnagrams(s1, s2));
    }
    private static boolean isValidAnagrams(String s1,String s2) {
        char []c1=s1.toCharArray();
        char []c2=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String s3=new String(c1);
        String s4=new String(c2);
        System.out.println(s3+s4);
        if (s3.equals(s4))
            return true;
        else
            return false;
    }
}